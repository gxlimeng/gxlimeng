package com.duopei.system.user.model;

import com.duopei.base.BaseDto;

public class User extends BaseDto {

	private static final long serialVersionUID = -1146355170439214947L;

	private int userNo;
	private String userCode;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String userTel;
	private int userStatus;
	private String commons;

	public User() {

	}

	public User(int userNo, String userCode, String userName, String userPwd, String userEmail, String userTel, int userStatus, String commons) {
		super();
		this.userNo = userNo;
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userTel = userTel;
		this.userStatus = userStatus;
		this.commons = commons;
	}

	public User(Integer userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "\n User [userNo=" + userNo + ", userCode=" + userCode + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail + ", userTel=" + userTel + ", userStatus="
				+ userStatus + ", commons=" + commons + "] ";
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getCommons() {
		return commons;
	}

	public void setCommons(String commons) {
		this.commons = commons;
	}

}
