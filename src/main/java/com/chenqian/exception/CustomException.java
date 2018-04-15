package com.chenqian.exception;

/**
 * 全局异常处理
 */
public class CustomException extends Exception{

    public String message;

    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
