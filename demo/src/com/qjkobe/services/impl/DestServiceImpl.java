package com.qjkobe.services.impl;

import com.qjkobe.db.dao.TGoodsDestMapper;
import com.qjkobe.db.model.TGoodsDest;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.DestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
@Service("destService")
@Transactional
public class DestServiceImpl implements DestService {

    @Autowired
    TGoodsDestMapper tGoodsDestMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<TGoodsDest> getDestListByParam(TGoodsDest dest, Order order, Pager page) {
        if(page != null){
            int count = tGoodsDestMapper.selectCountByParam(dest);
            page.setRecordCount(count);
        }
        return tGoodsDestMapper.selectListByParam(dest, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addDest(TGoodsDest dest) {
        tGoodsDestMapper.insertSelective(dest);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyDest(TGoodsDest dest) {
        tGoodsDestMapper.updateByPrimaryKeySelective(dest);
    }

    @Override
    @Transactional(readOnly = true)
    public TGoodsDest getDestById(String id) {
        return tGoodsDestMapper.selectByPrimaryKey(id);
    }
}
