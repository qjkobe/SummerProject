package com.qjkobe.services;

import com.qjkobe.db.model.Route;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface RouteService {
    public List<Route> getRouteListByParam(Route route, Order order, Pager page);

    public void addRoute(Route route);

    public void modifyRoute(Route route);

    public Route getRouteById(int id);
}
