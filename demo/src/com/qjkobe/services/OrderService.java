package com.qjkobe.services;

import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface OrderService {
    public List<Orderlist> getOrderListByParam(Orderlist orderlist, Order order, Pager page);

    public void addOrder(Orderlist orderlist);

    public void modifyOrder(Orderlist orderlist);

    public Orderlist getOrderById(String id);
}
