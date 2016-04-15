package com.duopei.other.rest.dao;

import java.util.List;

import com.duopei.core.model.user.User;


public interface TUsersMapper {

	List<User> selectUsers(User user);

	void delete(User user);

	void insert(User user);

	void updateByPrimaryKey(User user);
}