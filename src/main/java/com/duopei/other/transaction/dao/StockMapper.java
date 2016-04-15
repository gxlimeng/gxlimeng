package com.duopei.other.transaction.dao;

import com.duopei.other.transaction.model.Stock;
import com.duopei.other.transaction.model.StockKey;

public interface StockMapper {
	
    int deleteByPrimaryKey(StockKey key);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(StockKey key);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}