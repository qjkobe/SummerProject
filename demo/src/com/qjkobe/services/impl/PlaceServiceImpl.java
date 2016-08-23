package com.qjkobe.services.impl;

import com.qjkobe.db.dao.PlaceMapper;
import com.qjkobe.db.model.Place;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceMapper placeMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Place> getPlaceListByParam(Place place, Order order, Pager page) {
        if (page != null) {
            int count = placeMapper.selectCountByParam(place);
            page.setRecordCount(count);
        }
        return placeMapper.selectListByParam(place, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPlace(Place place) {
        placeMapper.insertSelective(place);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPlace(Place place) {
        placeMapper.updateByPrimaryKeySelective(place);
    }

    @Override
    @Transactional(readOnly = true)
    public Place getPlaceById(String id) {
        return placeMapper.selectByPrimaryKey(id);
    }
}
