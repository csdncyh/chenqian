package com.chenqian.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * json统一格式
 */
public class Result {
    private String code;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();

    public static Result success(String str){
        Result result = new Result();
        result.setCode("1");
        result.setMessage(str);
        return result;
    }

    public static Result error(String str){
        Result result = new Result();
        result.setCode("0");
        result.setMessage(str);
        return result;
    }

    public Result add(String key, Object value){
        this.getData().put(key, value);
        return this;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"code\":\""+this.code+"\",\"message\":\""+this.message+"\"}";
    }
}
