package com.qjkobe.services;

import com.qjkobe.db.model.TGoodsDest;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public interface DestService {
    public List<TGoodsDest> getDestListByParam(TGoodsDest dest, Order order, Pager page);

    public void addDest(TGoodsDest dest);

    public void modifyDest(TGoodsDest dest);

    public TGoodsDest getDestById(String id);
}
