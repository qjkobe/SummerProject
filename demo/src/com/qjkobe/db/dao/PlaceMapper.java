package com.qjkobe.db.dao;

import com.qjkobe.db.model.Place;

public interface PlaceMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
}