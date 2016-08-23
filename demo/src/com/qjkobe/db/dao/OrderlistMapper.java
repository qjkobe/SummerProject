package com.qjkobe.db.dao;

import com.qjkobe.db.model.Orderlist;

public interface OrderlistMapper extends BaseMapper {
    int deleteByPrimaryKey(String oid);

    int insert(Orderlist record);

    int insertSelective(Orderlist record);

    Orderlist selectByPrimaryKey(String oid);

    int updateByPrimaryKeySelective(Orderlist record);

    int updateByPrimaryKey(Orderlist record);
}