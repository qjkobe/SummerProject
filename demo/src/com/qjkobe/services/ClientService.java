package com.qjkobe.services;

import com.qjkobe.db.model.Client;
import com.qjkobe.db.model.param.Order;
import com.qjkobe.db.model.param.Pager;

import java.util.List;

/**
 * Created by Clientistrator on 2016/8/22.
 */
public interface ClientService {
    public List<Client> getClientListByParam(Client client, Order order, Pager page);

    public void addClient(Client client);

    public void modifyClient(Client client);

    public Client getClientById(int id);
}
