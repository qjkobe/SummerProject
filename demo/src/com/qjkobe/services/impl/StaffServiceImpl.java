package com.qjkobe.services.impl;

import com.qjkobe.db.dao.StaffMapper;
import com.qjkobe.db.model.Staff;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("staffService")
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Staff> getStaffListByParam(Staff staff, Order order, Pager page) {
        if (page != null) {
            int count = staffMapper.selectCountByParam(staff);
            page.setRecordCount(count);
        }
        return staffMapper.selectListByParam(staff, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addStaff(Staff staff) {
        staffMapper.insertSelective(staff);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyStaff(Staff staff) {
        staffMapper.updateByPrimaryKeySelective(staff);
    }

    @Override
    @Transactional(readOnly = true)
    public Staff getStaffById(String id) {
        return staffMapper.selectByPrimaryKey(id);
    }
}
