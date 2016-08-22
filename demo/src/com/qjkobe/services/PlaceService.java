package com.qjkobe.services;

import com.qjkobe.db.model.Place;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface PlaceService {
    public List<Place> getPlaceListByParam(Place place, Order order, Pager page);

    public void addPlace(Place place);

    public void modifyPlace(Place place);

    public Place getPlaceById(int id);
}
