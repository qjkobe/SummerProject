package com.qjkobe.action.order;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.Route;
import com.qjkobe.db.model.Staff;
import com.qjkobe.entity.Node;
import com.qjkobe.services.OrderService;
import com.qjkobe.services.RouteService;
import com.qjkobe.services.StaffService;
import com.qjkobe.utils.Const;
import com.qjkobe.utils.Dijkstra;
import com.qjkobe.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

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

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "addOrder")
    @ResponseBody
    public String addOrder(Orderlist orderlist, String staffName, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(orderlist.getExpense()) || StringUtils.isEmpty(orderlist.getDestination()) || StringUtils.isEmpty(orderlist.getRid())){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }


        Staff staff = new Staff();
        staff.setUsername(staffName);
        staff = staffService.getStaffListByParam(staff, null, null).get(0);

        orderlist.setSid(staff.getSid());

        //覆盖之前的订单
        Orderlist query = new Orderlist();
        query.setSid(staff.getSid());
        query.setCid(orderlist.getCid());
        List<Orderlist> list1 = orderService.getOrderListByParam(query, null, null);
        if(list1.size() > 0){
            if(list1.get(0).getStatus() != 0){
                jsonObject.put("state", Const.EXIST_STATE);
                return jsonObject.toString();
            }
            orderlist.setOid(list1.get(0).getOid());
            orderlist.setStatus(0);
            orderlist.setXiadantime(new Date());
            orderService.modifyOrder(orderlist);
            jsonObject.put("state", Const.SUCCESS_STATE);
            return jsonObject.toString();
        }

        orderlist.setOid(UUID.getID());
        orderlist.setStatus(0);
        orderlist.setXiadantime(new Date());

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

    @RequestMapping(value = "getRoute" ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getRoute(Orderlist orderlist, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(orderlist.getDestination())){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }

        Route route = new Route();
        Dijkstra test=new Dijkstra();
        Node start=test.init();
        test.computePath(start);
        if(StringUtils.isEmpty(test.getPath(orderlist.getDestination()))){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }
        route.setPlace(test.getPath(orderlist.getDestination()));

        List<Route> list1 = routeService.getRouteListByParam(route, null, null);
        if(list1.size() > 0){
            route = list1.get(0);
            jsonObject.put("state", Const.SUCCESS_STATE);
            jsonObject.put("route", route);
            return jsonObject.toString();
        }

        route.setDaodatime("暂时为空");
        route.setRid(UUID.getID());
        routeService.addRoute(route);
        jsonObject.put("state", Const.SUCCESS_STATE);
        jsonObject.put("route", route);
        return jsonObject.toString();
    }
}
