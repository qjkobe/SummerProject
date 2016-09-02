package com.qjkobe.action.admin;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Admin;
import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.TVisitNum;
import com.qjkobe.services.AdminService;
import com.qjkobe.services.OrderService;
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
@RequestMapping(value = "admin")
public class AdminAction {

    @Autowired
    AdminService adminService;

    @Autowired
    VisitService visitService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "getvisit")
    @ResponseBody
    public String GetVisit(String username, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if(StringUtils.isEmpty(username)){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        List<Admin> list1 = adminService.getAdminListByParam(admin, null, null);
        if(list1.size() == 0){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }
        admin = list1.get(0);
        TVisitNum tVisitNum = new TVisitNum();
        tVisitNum.setUserid(admin.getAid());
        List<TVisitNum> list2 = visitService.getVisitListByParam(tVisitNum, null, null);
        resObj.put("state", Const.SUCCESS_STATE);
        if(list2.size() == 0){
            tVisitNum.setId(UUID.getID());
            tVisitNum.setAllvisit(0);
            tVisitNum.setDayvisit(0);
            visitService.addVisit(tVisitNum);
            resObj.put("visitNum", tVisitNum);
        }else{
            tVisitNum = list2.get(0);
            resObj.put("visitNum", tVisitNum);
        }
        return resObj.toString();
    }

    /**
     * 获得销售业绩
     * @param username 用户名
     * @param response
     * @return
     */
    @RequestMapping(value = "getperformance")
    @ResponseBody
    public String getPerformance(String username, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if(StringUtils.isEmpty(username)){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        List<Admin> list1 = adminService.getAdminListByParam(admin, null, null);
        if(list1.size() == 0){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }

        Orderlist orderlist = new Orderlist();
        orderlist.setStatus(2);
        List<Orderlist> list2 = orderService.getOrderListByParam(orderlist, null, null);
        resObj.put("state", Const.SUCCESS_STATE);
        resObj.put("performance", list2.size());
        return resObj.toString();
    }

    /**
     * 获得进行中的订单
     * @param username 用户名
     * @param response
     * @return
     */
    @RequestMapping(value = "getOrdering", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getOrdering(String username, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject resObj = new JSONObject();
        if(StringUtils.isEmpty(username)){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        List<Admin> list1 = adminService.getAdminListByParam(admin, null, null);
        if(list1.size() == 0){
            resObj.put("state", Const.ERROR_STATE);
            return resObj.toString();
        }

        Orderlist orderlist = new Orderlist();
        orderlist.setStatus(1);
        List<Orderlist> list2 = orderService.getOrderListByParam(orderlist, null, null);
        resObj.put("state", Const.SUCCESS_STATE);
        resObj.put("orders", list2);
        return resObj.toString();
    }
}
