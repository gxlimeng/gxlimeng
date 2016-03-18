package com.duopei.system.user.service;

import com.duopei.system.user.model.Login;

/**
 * 用户登录
 * @author gxlimeng
 *
 */
public interface LoginService {
	
	/**
	 *  是否有此用户,并返回
	 * @param login
	 */
	public Login selectByPrimaryKey(Login login);

	/**
	 *  根据登录key，查询并返回用户信息
	 * @param loginKey
	 * @return
	 */
	public Login selectByLoginKey(String loginKey);
	
}
