package com.qjkobe.action.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Client;
import com.qjkobe.db.model.Goods;
import com.qjkobe.services.ClientService;
import com.qjkobe.services.GoodsService;
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
}
