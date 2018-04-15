package com.chenqian.service;

import com.chenqian.exception.CustomException;
import com.chenqian.vo.UserRegVo;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户注册服务
 */
public interface RegService {
    /**
     * 处理注册，发送邮件
     */
    void regHandler(UserRegVo userRegVo) throws CustomException;

    /**
     * 用户激活账号
     */
    void activateHandler(HttpServletRequest request) throws CustomException;
}
