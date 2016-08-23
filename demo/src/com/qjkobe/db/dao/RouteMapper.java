package com.qjkobe.db.dao;

import com.qjkobe.db.model.Route;

public interface RouteMapper extends BaseMapper {
    int deleteByPrimaryKey(String rid);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(String rid);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}