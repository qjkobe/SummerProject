package com.qjkobe.db.dao;

import com.qjkobe.db.model.Staff;

public interface StaffMapper extends BaseMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}