package com.duopei.core.model.user;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.duopei.core.model.BaseDto;


public class User extends BaseDto {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer no;

    @NotNull
    private String userCode;

    @NotNull
    private String userName;

    @NotNull
    private String userPwd;

    @NotNull
    private String userTel;

    @Email
    private String userEmail;

    private Integer userStatus;

    private String commons;

    private Date lastLoginTime;

    private Date lastUpdatePwdDate;

    public User(Integer no) {
    	this.no = no;
	}
    
    public User(String userName) {
    	this.userName = userName;
	}
	public User() {
	}

	public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getCommons() {
        return commons;
    }

    public void setCommons(String commons) {
        this.commons = commons == null ? null : commons.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastUpdatePwdDate() {
        return lastUpdatePwdDate;
    }

    public void setLastUpdatePwdDate(Date lastUpdatePwdDate) {
        this.lastUpdatePwdDate = lastUpdatePwdDate;
    }
    
}