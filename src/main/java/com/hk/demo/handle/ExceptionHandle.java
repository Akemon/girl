package com.hk.demo.handle;

import com.hk.demo.bean.Result;
import com.hk.demo.exception.GirlException;
import com.hk.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 何康
 * @date 2018/8/11 14:46
 */
@ControllerAdvice
public class ExceptionHandle {
    //日志查看异常
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            //控制台的打印异常
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }

}
