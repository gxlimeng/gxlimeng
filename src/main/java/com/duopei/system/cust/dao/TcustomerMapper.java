package com.duopei.system.cust.dao;

import com.duopei.system.cust.model.Tcustomer;

public interface TcustomerMapper {
    int deleteByPrimaryKey(String custNo);

    int insert(Tcustomer record);

    int insertSelective(Tcustomer record);

    Tcustomer selectByPrimaryKey(String custNo);

    int updateByPrimaryKeySelective(Tcustomer record);

    int updateByPrimaryKey(Tcustomer record);
}