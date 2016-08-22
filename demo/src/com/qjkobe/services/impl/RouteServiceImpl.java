package com.qjkobe.services.impl;

import com.qjkobe.db.dao.RouteMapper;
import com.qjkobe.db.model.Route;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("routeService")
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteMapper routeMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Route> getRouteListByParam(Route route, Order order, Pager page) {
        if (page != null) {
            int count = routeMapper.selectCountByParam(route);
            page.setRecordCount(count);
        }
        return routeMapper.selectListByParam(route, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoute(Route route) {
        routeMapper.insertSelective(route);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyRoute(Route route) {
        routeMapper.updateByPrimaryKeySelective(route);
    }

    @Override
    @Transactional(readOnly = true)
    public Route getRouteById(int id) {
        return routeMapper.selectByPrimaryKey(id);
    }
}
