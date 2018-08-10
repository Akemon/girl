package com.hk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello spring boot";
    }
}
