package com.qjkobe.services.impl;

import com.qjkobe.db.dao.TVisitNumMapper;
import com.qjkobe.db.model.TVisitNum;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    @Autowired
    TVisitNumMapper tVisitNumMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<TVisitNum> getVisitListByParam(TVisitNum visitNum, Order order, Pager page) {
        if (page != null) {
            int count = tVisitNumMapper.selectCountByParam(visitNum);
            page.setRecordCount(count);
        }
        return tVisitNumMapper.selectListByParam(visitNum, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addVisit(TVisitNum visitNum) {
        tVisitNumMapper.insertSelective(visitNum);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyVisit(TVisitNum visitNum) {
        tVisitNumMapper.updateByPrimaryKeySelective(visitNum);
    }

    @Override
    @Transactional(readOnly = true)
    public TVisitNum getVisitById(String id) {
        return tVisitNumMapper.selectByPrimaryKey(id);
    }
}
