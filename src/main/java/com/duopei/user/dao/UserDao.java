package com.duopei.user.dao;

import com.duopei.user.model.User;

public interface UserDao {

	public int insertUser(User user);

	public User getUserById(User user);

}
