package com.qjkobe.db.dao;

import com.qjkobe.db.model.Staff;

public interface StaffMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}