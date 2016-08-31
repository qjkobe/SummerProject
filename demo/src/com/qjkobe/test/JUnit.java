package com.qjkobe.test;

import com.qjkobe.db.model.TPlace;
import com.qjkobe.services.PositionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class JUnit {

    @Test
    public void Test(){
        String[] paths = new String[] { "spring/applicationContext-bo.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);

        PositionService positionService = (PositionService) ctx.getBean("positionService");

        TPlace place = new TPlace();
        place.setIsdelete(0);
        List<TPlace> list1 = positionService.getPostListByParam(place, null, null);
        System.out.println(list1.size());
    }
}
