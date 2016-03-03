package com.duopei.system.cust.service.impl;

import org.springframework.stereotype.Service;

import com.duopei.system.cust.model.Tcustomer;
import com.duopei.system.cust.service.TcustomerService;

@Service(value = "tcustomerService")
public class TcustomerServiceImpl implements TcustomerService{

	@Override
	public int deleteByPrimaryKey(String custNo) {
		return 0;
	}

	@Override
	public int insert(Tcustomer record) {
		return 0;
	}

	@Override
	public int insertSelective(Tcustomer record) {
		return 0;
	}

	@Override
	public Tcustomer selectByPrimaryKey(String custNo) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Tcustomer record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Tcustomer record) {
		return 0;
	}
 
}
