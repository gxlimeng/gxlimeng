package com.duopei.other.transaction.model;

public class StockKey {
	
	private String whCode;

	private String itemCode;

	private String unitCode;

	public StockKey() {

	}

	public StockKey(String whCode, String itemCode, String unitCode) {
		this.whCode = whCode;
		this.itemCode = itemCode;
		this.unitCode = unitCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode == null ? null : whCode.trim();
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