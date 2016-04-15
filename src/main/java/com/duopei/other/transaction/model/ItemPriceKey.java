package com.duopei.other.transaction.model;

public class ItemPriceKey {
	
	private String itemCode;

	private String unitCode;

	public ItemPriceKey() {

	}

	public ItemPriceKey(String itemCode, String unitCode) {
		this.itemCode = itemCode;
		this.unitCode = unitCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode == null ? null : itemCode.trim();
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode == null ? null : unitCode.trim();
	}
}