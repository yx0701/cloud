package com.yx.auth;

import com.yx.auth.testpackage.CityPefDao;
import com.yx.auth.testpackage.RcuCallAndOccupyRatio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private CityPefDao cityPefDao;
    @Test
    public void contextLoads() {

        long systemTime=System.currentTimeMillis();


        List<RcuCallAndOccupyRatio> li = cityPefDao.sortCallAndOccupy(new Timestamp(1568708700000L),new Timestamp(1568908800000L),"asc",1,10);
        Timestamp timestamp1 = new Timestamp(1568708700000L);
        Timestamp timestamp2 = new Timestamp(1568908800000L);

        System.out.println();
    }

}
