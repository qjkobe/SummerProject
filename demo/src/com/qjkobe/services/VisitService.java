package com.qjkobe.services;

import com.qjkobe.db.model.TVisitNum;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface VisitService {
    public List<TVisitNum> getVisitListByParam(TVisitNum visitNum, Order order, Pager page);

    public void addVisit(TVisitNum visitNum);

    public void modifyVisit(TVisitNum visitNum);

    public TVisitNum getVisitById(String id);
}
