package com.hk.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 何康
 * @date 2018/8/10 11:55
 */
@Aspect
@Component
public class HttpAspect {

    //使用spring自带的日志
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //定义一个切点为多个方法执行相同的切面选择
    @Pointcut("execution(public * com.hk.demo.controller.GirlController.*(..))")
    public void publicCheck(){ }

    //@Before执行方法前的操作
//    @Before("execution(public * com.hk.demo.controller.GirlController.girlList(..))")
    @Before( "publicCheck()")
    public void login(JoinPoint joinPoint){
//        System.out.println("111111111");
//        logger.info("11111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    //@After执行方法结束后的操作
    @After("publicCheck()")
    public void doAfter(){
//        System.out.print("22222222222");
        logger.info("22222222");
    }


    //获取方法返回值的内容
    @AfterReturning(returning = "object",pointcut = "publicCheck()")
    public void doAfterReturning(Object object){
        //如果controller的方法没有返回值，即object为null,调用toString会产生nullPointerException
        logger.info("response={}",object.toString());
    }
}
