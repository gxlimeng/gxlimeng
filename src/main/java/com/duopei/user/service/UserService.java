package com.duopei.user.service;

import java.util.List;

import com.duopei.user.model.User;

public interface UserService {

	/**
	 * 根据帐户ID查找帐户信息
	 * 
	 * @param user
	 * @return
	 */
	public User getUserById(User user);

	/**
	 * 根据帐户信息查找帐户信息LIST
	 * 
	 * @param user
	 * @return
	 */
	public List<User> getUserLst(User user);

	/**
	 * 新增账号信息
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(User user);

	/**
	 * 删除顾客账号信息
	 * 
	 * @param user
	 * @return
	 */
	public int deleteUser(User user);

}
