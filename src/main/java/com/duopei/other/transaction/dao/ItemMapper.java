package com.duopei.other.transaction.dao;

import com.duopei.other.transaction.model.Item;

public interface ItemMapper {
    int insert(Item record);

    int insertSelective(Item record);
}