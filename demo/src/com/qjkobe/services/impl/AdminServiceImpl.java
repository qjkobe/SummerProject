package com.qjkobe.services.impl;

import com.qjkobe.db.dao.AdminMapper;
import com.qjkobe.db.model.Admin;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Admin> getAdminListByParam(Admin admin, Order order, Pager page) {
        if (page != null) {
            int count = adminMapper.selectCountByParam(admin);
            page.setRecordCount(count);
        }
        return adminMapper.selectListByParam(admin, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAdmin(Admin admin) {
        adminMapper.insertSelective(admin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyAdmin(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    @Transactional(readOnly = true)
    public Admin getAdminById(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
