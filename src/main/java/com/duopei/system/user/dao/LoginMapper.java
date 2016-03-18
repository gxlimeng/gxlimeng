package com.duopei.system.user.dao;

import com.duopei.system.user.model.Login;

public interface LoginMapper {
	
    int deleteByPrimaryKey(Integer userId);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    /**
     * 根据登录key，查询并返回用户信息
     * @param loginKey
     * @return
     */
	Login selectByLoginKey(String loginKey);
}