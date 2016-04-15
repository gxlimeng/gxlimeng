package com.duopei.other.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duopei.core.model.user.User;
import com.duopei.other.rest.dao.TUsersMapper;
import com.duopei.other.rest.service.TRestUserService;

@Service(value = "trestUserService")
public class TRestUserServiceImpl  implements TRestUserService{

	@Autowired
	private TUsersMapper tuserMapper ;

	@Override
	public List<User> selectUsers(User user) {
		return tuserMapper.selectUsers(user);
	}

	@Override
	public void delete(User user) {
		tuserMapper.delete(user);
	}

	@Override
	public void insert(User user) {
		tuserMapper.insert(user);
	}

	@Override
	public void updateByPrimaryKey(User user) {
		tuserMapper.updateByPrimaryKey(user);
	} 
}
