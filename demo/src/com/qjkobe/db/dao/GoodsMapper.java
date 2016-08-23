package com.qjkobe.db.dao;

import com.qjkobe.db.model.Goods;

public interface GoodsMapper extends BaseMapper {
    int deleteByPrimaryKey(String gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}