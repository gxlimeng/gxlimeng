package com.duopei.system.cust.service;

import com.duopei.system.cust.model.Tcustomer;

public interface TcustomerService {

	int deleteByPrimaryKey(String custNo);

	int insert(Tcustomer record);

	int insertSelective(Tcustomer record);

	Tcustomer selectByPrimaryKey(String custNo);

	int updateByPrimaryKeySelective(Tcustomer record);

	int updateByPrimaryKey(Tcustomer record);

}
