package com.duopei.other.transaction.dao;

import com.duopei.other.transaction.model.ItemPrice;
import com.duopei.other.transaction.model.ItemPriceKey;

public interface ItemPriceMapper {
    int deleteByPrimaryKey(ItemPriceKey key);

    int insert(ItemPrice record);

    int insertSelective(ItemPrice record);

    ItemPrice selectByPrimaryKey(ItemPriceKey key);

    int updateByPrimaryKeySelective(ItemPrice record);

    int updateByPrimaryKey(ItemPrice record);
}