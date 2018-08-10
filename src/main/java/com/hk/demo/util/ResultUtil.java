package com.hk.demo.util;

import com.hk.demo.bean.Result;

/**
 * @author 何康
 * @date 2018/8/10 17:09
 */
public class ResultUtil {


    public static Result success(Object object){
        Result result =new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }
    public static Result error(String message){
        Result result =new Result();
        result.setCode(100);
        result.setMessage(message);
        return result;
    }
}
