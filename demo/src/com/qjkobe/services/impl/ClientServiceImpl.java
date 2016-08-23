package com.qjkobe.services.impl;

import com.qjkobe.db.dao.ClientMapper;
import com.qjkobe.db.model.Client;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;
import com.qjkobe.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Client> getClientListByParam(Client client, Order order, Pager page) {
        if (page != null) {
            int count = clientMapper.selectCountByParam(client);
            page.setRecordCount(count);
        }
        return clientMapper.selectListByParam(client, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addClient(Client client) {
        clientMapper.insertSelective(client);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyClient(Client client) {
        clientMapper.updateByPrimaryKeySelective(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClientById(String id) {
        return clientMapper.selectByPrimaryKey(id);
    }
}
