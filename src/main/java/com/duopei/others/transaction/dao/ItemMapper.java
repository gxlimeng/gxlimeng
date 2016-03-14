package com.duopei.others.transaction.dao;

import com.duopei.others.transaction.model.Item;

public interface ItemMapper {
    int insert(Item record);

    int insertSelective(Item record);
}