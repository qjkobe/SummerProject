package com.qjkobe.services.impl;

import com.qjkobe.db.dao.GoodsMapper;
import com.qjkobe.db.model.Goods;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Goods> getGoodsListByParam(Goods goods, Order order, Pager page) {
        if (page != null) {
            int count = goodsMapper.selectCountByParam(goods);
            page.setRecordCount(count);
        }
        return goodsMapper.selectListByParam(goods, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    @Transactional(readOnly = true)
    public Goods getGoodsById(String id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
