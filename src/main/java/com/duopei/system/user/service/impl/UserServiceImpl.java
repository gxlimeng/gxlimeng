package com.duopei.system.user.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duopei.system.user.dao.UserMapper;
import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(User user) {
		return userMapper.getUserById(user);
	}

	@Override
	public List<User> getUserLst(User user) {
		return userMapper.getUserLst(user);
	}

	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

	// 增加事务注解:表示方法checkUser中是使用的同一个事物 (和其它service的事务独立)
	@Transactional
	@Override
	public void checkUser(User user) {
		if (null != userMapper.getUserById(user)) {
			userMapper.deleteUser(user);
		}
		userMapper.insertUser(user);
	}
	
	@Transactional
	@Override
	public void checkUser2(User user) {
		if (null != userMapper.getUserById(user)) {
			userMapper.deleteUser(user);
		}
		//int i = 20 / 0;
		//logger.info("i"+i);
		userMapper.insertUser(user);
	}
}
