package com.hk.demo.bean;

/**
 * @author 何康
 * @date 2018/8/10 16:57
 */
public class Result<T>{
    //错误码
    private int code;

    //具体信息
    private String message;

    //具体内容
    private T  data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
