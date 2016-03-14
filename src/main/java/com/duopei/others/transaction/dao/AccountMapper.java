package com.duopei.others.transaction.dao;

import com.duopei.others.transaction.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String custNo);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String custNo);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}