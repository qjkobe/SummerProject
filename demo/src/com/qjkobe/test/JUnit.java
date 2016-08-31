package com.qjkobe.test;

import com.qjkobe.db.model.TGoodsDest;
import com.qjkobe.services.DestService;
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

        DestService destService = (DestService) ctx.getBean("destService");

        TGoodsDest tGoodsDest = new TGoodsDest();
        List<TGoodsDest> list1 = destService.getDestListByParam(tGoodsDest, null, null);
        System.out.println(list1.size());
    }
}
