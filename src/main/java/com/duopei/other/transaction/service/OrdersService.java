package com.duopei.other.transaction.service;

import java.util.ArrayList;

import com.duopei.other.transaction.model.ItemPriceKey;

public interface OrdersService {

	/**
	 *  下多单 对比 OrderService 事务管理进行对比
	 * @param custNo
	 * @param itemList
	 * @throws Exception
	 */
	public void orders(String custNo, ArrayList<ItemPriceKey> itemList) throws Exception;
}
