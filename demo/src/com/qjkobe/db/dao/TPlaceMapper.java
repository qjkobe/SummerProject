package com.qjkobe.db.dao;

import com.qjkobe.db.model.TPlace;

public interface TPlaceMapper extends BaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPlace record);

    int insertSelective(TPlace record);

    TPlace selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPlace record);

    int updateByPrimaryKey(TPlace record);
}