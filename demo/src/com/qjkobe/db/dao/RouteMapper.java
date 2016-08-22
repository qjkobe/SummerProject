package com.qjkobe.db.dao;

import com.qjkobe.db.model.Route;

public interface RouteMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}