package com.hk.demo;

import com.hk.demo.bean.Girl;
import com.hk.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 何康
 * @date 2018/8/11 15:42
 */
//表示跑在spring的环境上
@RunWith(SpringRunner.class)
//启动整个工程
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl =girlService.findOneGirl(1);
//        Assert.assertEquals(new Integer(6),girl.getAge());
    }
}
