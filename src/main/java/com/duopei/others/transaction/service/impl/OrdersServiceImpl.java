package com.duopei.others.transaction.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.duopei.others.transaction.model.ItemPriceKey;
import com.duopei.others.transaction.service.OrderService;
import com.duopei.others.transaction.service.OrdersService;

@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrderService orderService = null;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void orders(String custNo, ArrayList<ItemPriceKey> itemList) throws Exception {
		for (ItemPriceKey itemPriceKey : itemList) {
			orderService.order(custNo, itemPriceKey.getItemCode(), itemPriceKey.getUnitCode());
		}
	}

}
