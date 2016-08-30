package com.qjkobe.action.place;

import com.alibaba.fastjson.JSONObject;
import com.qjkobe.db.model.Place;
import com.qjkobe.db.model.TPlace;
import com.qjkobe.db.model.param.PagerImpl;
import com.qjkobe.services.PlaceService;
import com.qjkobe.services.PositionService;
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
 * Created by Administrator on 2016/8/29.
 */
@Controller
@RequestMapping(value = "place")
public class PlaceAction {

    @Autowired
    PlaceService placeService;

    @Autowired
    PositionService positionService;

    @RequestMapping(value = "showPlace", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showPlace(PagerImpl pager, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
//        Order order = new Order();
//        order.addOrder("updateTime", OrderSort.DESC);
        JSONObject jsonObject = new JSONObject();
        Place place = new Place();
        List<Place> list1 = placeService.getPlaceListByParam(place, null, pager);
        jsonObject.put("page", pager);
        jsonObject.put("place", list1);
        return jsonObject.toString();
    }

    @RequestMapping(value = "editPlace", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String editPlace(Place place, String actionFlag, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(place.getDistance()) || StringUtils.isEmpty(place.getNamex()) || StringUtils.isEmpty(place.getNamey())) {
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }
        if (Const.EDIT_UPDATE.equals(actionFlag)) {
            placeService.modifyPlace(place);
            jsonObject.put("state", Const.SUCCESS_STATE);
        } else if (Const.EDIT_ADD.equals(actionFlag)) {
            place.setPid(UUID.getID());
            placeService.addPlace(place);
            jsonObject.put("state", Const.SUCCESS_STATE);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "showPosition", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showPosition(PagerImpl pager, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
//        Order order = new Order();
//        order.addOrder("updateTime", OrderSort.DESC);
        JSONObject jsonObject = new JSONObject();
        TPlace place = new TPlace();
        List<TPlace> list1 = positionService.getPostListByParam(place, null, pager);
        jsonObject.put("page", pager);
        jsonObject.put("place", list1);
        return jsonObject.toString();
    }

    @RequestMapping(value = "editPosition", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String editPosition(TPlace place, String actionFlag, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(place.getName())) {
            jsonObject.put("state", Const.ERROR_STATE);
            return jsonObject.toString();
        }
        if (Const.EDIT_UPDATE.equals(actionFlag)) {
            positionService.modifyPost(place);
            jsonObject.put("state", Const.SUCCESS_STATE);
        } else if (Const.EDIT_ADD.equals(actionFlag)) {
            place.setId(UUID.getID());
            positionService.addPost(place);
            jsonObject.put("state", Const.SUCCESS_STATE);
        }
        return jsonObject.toString();
    }
}
