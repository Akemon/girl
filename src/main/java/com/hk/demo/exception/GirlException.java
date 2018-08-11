package com.hk.demo.exception;

import com.hk.demo.enums.GirlEnum;

/**
 * @author 何康
 * @date 2018/8/11 14:19
 */
//这里不云继承Exception 是因为spring不会对此种异常进行事务回滚
public class GirlException extends  RuntimeException{
    private Integer code;

    public GirlException(GirlEnum girlEnum) {
        super(girlEnum.getMessage());
        this.code = girlEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
