package com.duopei.system.user.service;

import java.util.List;

import com.duopei.system.user.model.User;

public interface UserService {

	/**
	 * 检查此用户是否存在，如存在，则删除后再新增，否则直接新增
	 * @param user
	 */
	public void checkUser(User user);
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
	void checkUser2(User user);

}
