package com.duopei.user.dao;

import java.util.List;

import com.duopei.user.model.User;

public interface UserDao {

	public int insertUser(User user);

	public User getUserById(User user);

	public List<User> getUserLst(User user);

	public int deleteUser(User user);

}
