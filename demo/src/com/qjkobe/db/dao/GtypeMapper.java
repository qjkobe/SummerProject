package com.qjkobe.db.dao;

import com.qjkobe.db.model.Gtype;

public interface GtypeMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Gtype record);

    int insertSelective(Gtype record);

    Gtype selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Gtype record);

    int updateByPrimaryKey(Gtype record);
}