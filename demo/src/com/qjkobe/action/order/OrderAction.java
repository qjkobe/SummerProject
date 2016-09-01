package com.qjkobe.action.order;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.Staff;
import com.qjkobe.services.OrderService;
import com.qjkobe.services.StaffService;
import com.qjkobe.utils.Const;
import com.qjkobe.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/9/1.
 */
@Controller
@RequestMapping(value = "order")
public class OrderAction {

    @Autowired
    OrderService orderService;

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "addOrder")
    @ResponseBody
    public String addOrder(Orderlist orderlist, String staffName, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(orderlist.getExpense()) || StringUtils.isEmpty(orderlist.getDestination()) || StringUtils.isEmpty(orderlist.getRid())){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }

        orderlist.setSid(UUID.getID());
        orderlist.setStatus(0);

        Staff staff = new Staff();
        staff.setUsername(staffName);
        staff = staffService.getStaffListByParam(staff, null, null).get(0);
        orderService.addOrder(orderlist);
        jsonObject.put("state", Const.SUCCESS_STATE);
        return jsonObject.toString();
    }

    @RequestMapping(value = "acceptOrder")
    @ResponseBody
    public String acceptOrder(Orderlist orderlist, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();

        orderlist.setStatus(1);
        orderService.modifyOrder(orderlist);
        jsonObject.put("state", Const.SUCCESS_STATE);
        return jsonObject.toString();
    }

    @RequestMapping(value = "finishOrder")
    @ResponseBody
    public String finishOrder(Orderlist orderlist, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();

        orderlist.setStatus(2);
        orderService.modifyOrder(orderlist);
        jsonObject.put("state", Const.SUCCESS_STATE);
        return jsonObject.toString();
    }
}
