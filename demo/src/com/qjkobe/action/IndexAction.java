package com.qjkobe.action;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Admin;
import com.qjkobe.db.model.Client;
import com.qjkobe.db.model.Staff;
import com.qjkobe.services.AdminService;
import com.qjkobe.services.ClientService;
import com.qjkobe.services.StaffService;
import com.qjkobe.services.VisitService;
import com.qjkobe.utils.Const;
import com.qjkobe.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@Controller
@RequestMapping(value = "index")
public class IndexAction {

    @Autowired
    AdminService adminService;

    @Autowired
    ClientService clientService;

    @Autowired
    StaffService staffService;

    @Autowired
    VisitService visitService;

    @RequestMapping(value = "login")
    @ResponseBody
    public String login(String username, String password, String type, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if("0".equals(type)){
            //管理员
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            List<Admin> list1 = adminService.getAdminListByParam(admin, null, null);
            if(list1.size() > 0){
                resObj.put("username", username);
                resObj.put("type", "admin");
            }
        }else if("1".equals(type)){
            //员工
            Staff staff = new Staff();
            staff.setUsername(username);
            staff.setPassword(password);
            List<Staff> list1 = staffService.getStaffListByParam(staff, null, null);
            if(list1.size() > 0){
                resObj.put("username", username);
                resObj.put("type", "staff");
            }
        }else if("2".equals(type)){
            //客户
            Client client = new Client();
            client.setUsername(username);
            client.setPassword(password);
            List<Client> list1 = clientService.getClientListByParam(client, null, null);
            if(list1.size() > 0){
                resObj.put("username", username);
                resObj.put("type", "client");
            }
        }
        return resObj.toString();
    }

    @RequestMapping(value = "register")
    @ResponseBody
    public String register(String username, String password, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }
        Client client = new Client();
        client.setUsername(username);
        List<Client> list1 = clientService.getClientListByParam(client, null, null);
        if(list1.size() > 0){
            resObj.put("state", Const.EXIST_STATE);
            return resObj.toString();
        }
        client.setPassword(password);
        client.setCid(UUID.getID());
        clientService.addClient(client);
        resObj.put("state", Const.SUCCESS_STATE);
        resObj.put("username", username);
        return resObj.toString();
    }

    @RequestMapping(value = "addstaff")
    @ResponseBody
    public String addStaff(Staff staff, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if(StringUtils.isEmpty(staff.getUsername()) || StringUtils.isEmpty(staff.getPassword())){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }
        Staff query1 = new Staff();
        query1.setUsername(staff.getUsername());
        List<Staff> list1 = staffService.getStaffListByParam(query1, null, null);
        if(list1.size() > 0){
            resObj.put("state", Const.EXIST_STATE);
            return resObj.toString();
        }
        staff.setSid(UUID.getID());
        staffService.addStaff(staff);
        resObj.put("state", Const.SUCCESS_STATE);
        return resObj.toString();
    }

}
