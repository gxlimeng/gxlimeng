package com.duopei.other.rest.service;

import java.util.List;

import com.duopei.core.model.user.User;


public interface TRestUserService {
	
	List<User> selectUsers(User user);

	void delete(User user);

	void insert(User user);

	void updateByPrimaryKey(User user);

}
