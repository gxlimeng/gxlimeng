package com.duopei.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duopei.user.dao.UserDao;
import com.duopei.user.model.User;
import com.duopei.user.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(User user) {
		return userDao.getUserById(user);
	}

}
