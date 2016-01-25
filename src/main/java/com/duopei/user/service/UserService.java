package com.duopei.user.service;

import com.duopei.user.model.User;

public interface UserService {

	/**
	 * 根据帐户ID查找帐户信息
	 * 
	 * @param user
	 * @return
	 */
	public User getUserById(User user);

}
