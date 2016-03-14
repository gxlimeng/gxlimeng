package com.duopei.others.transaction.dao;

import com.duopei.others.transaction.model.Stock;
import com.duopei.others.transaction.model.StockKey;

public interface StockMapper {
    int deleteByPrimaryKey(StockKey key);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(StockKey key);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}