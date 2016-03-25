package com.duopei.others.transaction.model;

import com.duopei.base.BaseDto;

public class Account extends BaseDto {
	
	private static final long serialVersionUID = -5775705201305282880L;

	private String custNo;

	private Double amt;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

}