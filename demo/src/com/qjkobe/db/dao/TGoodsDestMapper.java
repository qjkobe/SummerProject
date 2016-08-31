package com.qjkobe.db.dao;

import com.qjkobe.db.model.TGoodsDest;

public interface TGoodsDestMapper extends BaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(TGoodsDest record);

    int insertSelective(TGoodsDest record);

    TGoodsDest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TGoodsDest record);

    int updateByPrimaryKey(TGoodsDest record);
}