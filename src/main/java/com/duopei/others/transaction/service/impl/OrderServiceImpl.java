package com.duopei.others.transaction.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.duopei.others.transaction.dao.AccountMapper;
import com.duopei.others.transaction.dao.ItemPriceMapper;
import com.duopei.others.transaction.dao.StockMapper;
import com.duopei.others.transaction.model.Account;
import com.duopei.others.transaction.model.ItemPrice;
import com.duopei.others.transaction.model.ItemPriceKey;
import com.duopei.others.transaction.model.Stock;
import com.duopei.others.transaction.model.StockKey;
import com.duopei.others.transaction.service.OrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private AccountMapper accountMapper = null;

	@Autowired
	private StockMapper stockMapper = null;

	@Autowired
	private ItemPriceMapper itemPriceMapper = null;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void order(String custNo, String itemCode, String unitCode) throws Exception {
		// 模拟场景： 账号：1001 购买商品 10000001-销售价100

		// 1>获取账号余额 ，如无余额，则抛出异常。否则扣减余额并继续
		Account account = accountMapper.selectByPrimaryKey(custNo);
		ItemPrice itemPrice = itemPriceMapper.selectByPrimaryKey(new ItemPriceKey(itemCode, unitCode));
		if (account.getAmt() < itemPrice.getSalePrice()) {
			// spring声明式事务管理默认对非检查型异常和运行时异常进行事务回滚，而对检查型异常则不进行回滚操作
			throw new RuntimeException("余额不足");
		}
		account.setAmt(account.getAmt() - itemPrice.getSalePrice());
		accountMapper.updateByPrimaryKey(account);
		// 2>获取库存信息，如无库存，则抛出异常。否则扣减库存
		Stock stock = stockMapper.selectByPrimaryKey(new StockKey("100", itemCode, unitCode));
		logger.info("XXXXXXXXXXXX=" + JSON.toJSONString(stock, true));
		if (stock.getQty() <= 0) {
			throw new RuntimeException("库存不足");
		}
		// int i = 1/0;
		stock.setQty(stock.getQty() - 1);
		stockMapper.updateByPrimaryKey(stock);
	}

	@Transactional
	@Override
	public void orders(String custNo, ArrayList<ItemPriceKey> itemList) throws Exception {
		for (ItemPriceKey itemPriceKey : itemList) {
			this.order(custNo, itemPriceKey.getItemCode(), itemPriceKey.getUnitCode());
		}
	}

}
