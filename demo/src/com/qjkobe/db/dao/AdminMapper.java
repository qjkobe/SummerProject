package com.qjkobe.db.dao;

import com.qjkobe.db.model.Admin;

public interface AdminMapper extends BaseMapper {
    int deleteByPrimaryKey(String aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}