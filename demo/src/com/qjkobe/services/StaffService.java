package com.qjkobe.services;

import com.qjkobe.db.model.Staff;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface StaffService {
    public List<Staff> getStaffListByParam(Staff staff, Order order, Pager page);

    public void addStaff(Staff staff);

    public void modifyStaff(Staff staff);

    public Staff getStaffById(String id);
}
