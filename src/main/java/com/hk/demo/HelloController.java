package com.hk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private BoyProperties boyProperties;

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

//    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    //组合mapping
    @GetMapping(value = {"/hello","/hi"})
    public String hello(){
//        return "hello spring boot"+cupSize+age;
        return content+boyProperties.getHeight();
    }
    @RequestMapping(value = "getParam1",method = RequestMethod.GET)
    public String getParam1(@RequestParam("id") Integer id){
        return "id:"+id;
    }

    @RequestMapping(value = "getParam2/{id}",method = RequestMethod.GET)
    public String getParam2(@PathVariable("id") Integer id){
        return "id:"+id;
    }

}
