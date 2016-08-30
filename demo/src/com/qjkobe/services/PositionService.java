package com.qjkobe.services;

import com.qjkobe.db.model.TPlace;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface PositionService {
    public List<TPlace> getPostListByParam(TPlace place, Order order, Pager page);

    public void addPost(TPlace place);

    public void modifyPost(TPlace place);

    public TPlace getPostById(String id);
}
