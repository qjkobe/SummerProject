package com.qjkobe.services;

import com.qjkobe.db.model.Admin;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface AdminService {
    public List<Admin> getAdminListByParam(Admin admin, Order order, Pager page);

    public void addAdmin(Admin admin);

    public void modifyAdmin(Admin admin);

    public Admin getAdminById(String id);
}
