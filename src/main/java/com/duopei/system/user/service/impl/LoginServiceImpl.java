package com.duopei.system.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duopei.system.user.dao.LoginMapper;
import com.duopei.system.user.model.Login;
import com.duopei.system.user.service.LoginService;

/**
 * 用户登录
 * 
 * @author gxlimeng
 *
 */
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper = null;

	/**
	 * 是否有此用户,并返回
	 * 
	 * @param login
	 */
	public Login selectByPrimaryKey(Login login) {
		return new Login();
	}

	@Override
	public Login selectByLoginKey(String loginKey) {
		return loginMapper.selectByLoginKey(loginKey);
	}

}
