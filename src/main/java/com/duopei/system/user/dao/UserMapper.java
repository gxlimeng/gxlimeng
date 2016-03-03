package com.duopei.system.user.dao;

import java.util.List;

import com.duopei.system.user.model.User;

public interface UserMapper {

	public int insertUser(User user);

	public User getUserById(User user);

	public List<User> getUserLst(User user);

	public int deleteUser(User user);

}
