package com.duopei.oterhs.transaction;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.duopei.others.transaction.model.ItemPriceKey;
import com.duopei.others.transaction.service.OrderService;
import com.duopei.others.transaction.service.OrdersService;

@RunWith(SpringJUnit4ClassRunner.class) // equals extends
// SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestOrderServiceBySpring {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private OrderService orderService = null;

	@Autowired
	private OrdersService ordersService = null;

	@Test
	public void order() throws Exception {
		orderService.order("1001", "10000001", "001");
	}

	@Test
	public void orders() throws Exception {
		ArrayList<ItemPriceKey> itemList = new ArrayList<ItemPriceKey>();
		itemList.add(new ItemPriceKey("10000001", "001"));
		itemList.add(new ItemPriceKey("10000001", "001"));

		// 同一个service下，即使配置REQUIRES_NEW也不会重新创建事务
		orderService.orders("1001", itemList);

		// 不同service下，即使配置REQUIRES_NEW也不会重新创建事务
		ordersService.orders("1001", itemList);
	}

}
