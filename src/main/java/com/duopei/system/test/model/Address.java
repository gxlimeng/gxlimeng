package com.duopei.system.test.model;

public class Address {

	public Address() {
	}
	public Address(String add) {
		super();
		this.add = add;
	}

	private String add;

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Address [add=" + add + "]";
	}

}
