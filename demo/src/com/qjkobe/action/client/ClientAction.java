package com.qjkobe.action.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Client;
import com.qjkobe.db.model.Goods;
import com.qjkobe.db.model.Orderlist;
import com.qjkobe.db.model.TGoodsDest;
import com.qjkobe.services.ClientService;
import com.qjkobe.services.DestService;
import com.qjkobe.services.GoodsService;
import com.qjkobe.services.OrderService;
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
 * Created by Administrator on 2016/8/31.
 */
@Controller
@RequestMapping(value = "client")
public class ClientAction {

    @Autowired
    ClientService clientService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    DestService destService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "editGoods")
    @ResponseBody
    public String editGoods(Goods goods, String actionFlag, String clientName, String isdelete, String[] type, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(goods.getWeight())){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }
        if(isdelete != null && "0".equals(isdelete)){
            goods.setStatus(0);
        }else{
            goods.setStatus(1);
        }
        goods.setTid(JSON.toJSONString(type));

        Client client = new Client();
        client.setUsername(clientName);
        List<Client> list1 = clientService.getClientListByParam(client, null, null);
        if(Const.EDIT_ADD.equals(actionFlag)){
            goods.setGid(UUID.getID());
            goods.setCid(list1.get(0).getCid());
            goodsService.addGoods(goods);
            jsonObject.put("state", Const.SUCCESS_STATE);
        }else if(Const.EDIT_UPDATE.equals(actionFlag)){
            goodsService.modifyGoods(goods);
            jsonObject.put("state", Const.SUCCESS_STATE);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "getdest", produces = "html/text;charset=UTF-8")
    @ResponseBody
    public String getDest(TGoodsDest tGoodsDest, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();

        List<TGoodsDest> list1 = destService.getDestListByParam(tGoodsDest, null, null);
        if(list1.size() > 0){
            jsonObject.put("state", Const.EXIST_STATE);
            jsonObject.put("dest", list1.get(0));
            return jsonObject.toString();
        }
        jsonObject.put("state", Const.SUCCESS_STATE);
        return jsonObject.toString();
    }

    @RequestMapping(value = "editdest", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String editDest(TGoodsDest tGoodsDest, String actionFlag, String clientName, String isdelete, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isEmpty(tGoodsDest.getDest()) || StringUtils.isEmpty(tGoodsDest.getNickname())){
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }

        Client client = new Client();
        client.setUsername(clientName);
        List<Client> list1 = clientService.getClientListByParam(client, null, null);
        if(Const.EDIT_ADD.equals(actionFlag)){
            tGoodsDest.setId(UUID.getID());
            tGoodsDest.setCid(list1.get(0).getCid());
            destService.addDest(tGoodsDest);

            jsonObject.put("state", Const.SUCCESS_STATE);
        }else if(Const.EDIT_UPDATE.equals(actionFlag)){
            destService.modifyDest(tGoodsDest);
            jsonObject.put("state", Const.SUCCESS_STATE);
        }
        return jsonObject.toString();
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

        Client client = new Client();
        client.setUsername(username);
        List<Client> list1 = clientService.getClientListByParam(client, null, null);
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
