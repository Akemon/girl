package com.hk.demo.enums;

/**
 * @author 何康
 * @date 2018/8/11 15:22
 */
public enum GirlEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(101,"还在上小学"),
    NOT_GROW_UP(102,"未成年")
    ;

    private Integer code;

    private String message;

    GirlEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
