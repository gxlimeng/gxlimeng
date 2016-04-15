package com.duopei.other.transaction.service;

import java.util.ArrayList;

import com.duopei.other.transaction.model.ItemPriceKey;

public interface OrderService {

	/**
	 * 下单
	 * 
	 * @param custNo：顾客
	 * @param itemCode：商品
	 * @param unitCode：单件
	 * @throws Exception
	 */
	public void order(String custNo, String itemCode, String unitCode) throws Exception;

	/**
	 * 下多单
	 * 
	 * @param custNo
	 * @param itemList
	 */
	public void orders(String custNo, ArrayList<ItemPriceKey> itemList) throws Exception;

}
