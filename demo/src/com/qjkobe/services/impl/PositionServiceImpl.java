package com.qjkobe.services.impl;

import com.qjkobe.db.dao.TPlaceMapper;
import com.qjkobe.db.model.TPlace;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
@Service("positionService")
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    TPlaceMapper tPlaceMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<TPlace> getPostListByParam(TPlace place, Order order, Pager page) {
        if(page != null){
            int count = tPlaceMapper.selectCountByParam(place);
            page.setRecordCount(count);
        }
        return tPlaceMapper.selectListByParam(place, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPost(TPlace place) {
        tPlaceMapper.insertSelective(place);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPost(TPlace place) {
        tPlaceMapper.updateByPrimaryKeySelective(place);
    }

    @Override
    @Transactional(readOnly = true)
    public TPlace getPostById(String id) {
        return tPlaceMapper.selectByPrimaryKey(id);
    }
}
