package com.hk.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author 何康
 * @date 2018/8/11 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList()throws Exception {
        //http请求方法
        mvc.perform(MockMvcRequestBuilders.get("/getAllGirls"))
                //判断返回码是否成功
                .andExpect(MockMvcResultMatchers.status().isOk());
                //判断返回结果的相关类型
//                .andExpect(MockMvcResultMatchers.content().string("abc"));

    }
}