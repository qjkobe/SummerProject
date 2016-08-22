package com.qjkobe.db.dao;

import com.qjkobe.db.model.Client;

public interface ClientMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}