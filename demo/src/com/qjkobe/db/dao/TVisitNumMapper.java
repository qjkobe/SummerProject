package com.qjkobe.db.dao;

import com.qjkobe.db.model.TVisitNum;

public interface TVisitNumMapper extends BaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(TVisitNum record);

    int insertSelective(TVisitNum record);

    TVisitNum selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TVisitNum record);

    int updateByPrimaryKey(TVisitNum record);
}