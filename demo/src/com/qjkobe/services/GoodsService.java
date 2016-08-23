package com.qjkobe.services;

import com.qjkobe.db.model.Goods;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface GoodsService {
    public List<Goods> getGoodsListByParam(Goods goods, Order order, Pager page);

    public void addGoods(Goods goods);

    public void modifyGoods(Goods goods);

    public Goods getGoodsById(String id);
}
