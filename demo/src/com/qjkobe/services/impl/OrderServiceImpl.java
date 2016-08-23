package com.qjkobe.services.impl;

import com.qjkobe.db.dao.OrderlistMapper;
import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderlistMapper orderlistMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Orderlist> getOrderListByParam(Orderlist orderlist, Order order, Pager page) {
        if (page != null) {
            int count = orderlistMapper.selectCountByParam(orderlist);
            page.setRecordCount(count);
        }
        return orderlistMapper.selectListByParam(orderlist, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(Orderlist orderlist) {
        orderlistMapper.insertSelective(orderlist);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyOrder(Orderlist orderlist) {
        orderlistMapper.updateByPrimaryKeySelective(orderlist);
    }

    @Override
    @Transactional(readOnly = true)
    public Orderlist getOrderById(String id) {
        return orderlistMapper.selectByPrimaryKey(id);
    }
}
