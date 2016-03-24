package com.duopei.system.test.model;

public class User {

	private int userNo;
	private String userName;
	private String userPwd;
	private String userEmail;
	private Address address;

	public User() {

	}

	public User(int userNo, String userName, String userPwd, String userEmail, Address address) {
		this.userNo = userNo;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail + "]";
	}

	public User(int userNo, String userCode, String userName, String userPwd, String userEmail, String userTel, int userStatus, String commons) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
