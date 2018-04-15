package com.chenqian.service.impl;

import com.chenqian.Utils.MD5Util;
import com.chenqian.Utils.SendMailUtil;
import com.chenqian.controller.PageConfig;
import com.chenqian.dao.UserMapper;
import com.chenqian.entity.User;
import com.chenqian.exception.CustomException;
import com.chenqian.service.RegService;
import com.chenqian.vo.UserRegVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class RegServiceImpl implements RegService {

    @Autowired
    UserMapper userMapper;

    /**
     * 处理注册，发送邮件
     *      将邮箱加密，保存为字段checkcode内容
     */
    @Override
    public void regHandler(UserRegVo userRegVo) throws CustomException {
        User user = userMapper.selectByUserName(userRegVo.getUsername());
        if (user!=null){
          throw new CustomException("用户名已存在");
        }
        if(!StringUtils.isEmpty(userRegVo.getEmail())){
            throw new CustomException("邮箱已使用");
        }
        user = new User();
        user.setUsername(userRegVo.getUsername());
        user.setPassword(userRegVo.getPassword());
        user.setEmail(userRegVo.getEmail());
        String code= MD5Util.encode2hex(user.getEmail());
        user.setCheckCode(code);

        userMapper.insert(user);

        //邮件
        StringBuffer buffer = new StringBuffer("<!DOCTYPE html><html><head><title></title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><!-- 引入bootstrap --><!-- <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />--><!-- 引入JQuery  bootstrap.js--><!--<script type=\"text/javascript\" src=\"js/jquery-1.11.0.min.js\" ></script>--><link rel=\"stylesheet\" href=\"https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"><script src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script><script src=\"https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js\"></script><script src=\"https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\"></script><style></style></head><body><div class=\"container\" style=\"background:white\"><div><h5>尊敬的");
        buffer.append(user.getUsername()+"("+user.getEmail()+")");
        buffer.append(":您好:</h5>        感谢您加入晨签社区。        请点击以下链接进行邮箱验证，开始您的晨签之旅：<br>");
        buffer.append("<a class=\"btn btn-default btn-info\" href=\"");

        StringBuffer url = new StringBuffer(PageConfig.URL);
        url.append("user/activate/?email=");
        url.append(user.getEmail());
        url.append("&");
        url.append("checkCode=");
        url.append(user.getCheckCode());
        buffer.append(url);
        buffer.append("\">马上验证邮箱</a><br><p style=\"font-size: 14px;\">        如果您无法点击以上链接，请复制以下网址到浏览器里直接打开：<a href=\"");
        buffer.append(url);
        buffer.append("\">");
        buffer.append(url);
        buffer.append("</a>        如果您并未注册晨签网，可能是其他用户误输入了您的邮箱地址。请忽略此邮件。</p></div></body><script></script></html>");
        SendMailUtil.send(user.getEmail(), buffer.toString());
    }

    /**
     * 用户激活账号
     *  格式activate/?email=xxxx&checkCode=xxxx
     * @param request
     */
    @Override
    public void activateHandler(HttpServletRequest request) throws CustomException {
        String email = request.getParameter("email");
        User user = userMapper.selectByEmail(email);
        if (user == null){
            throw new CustomException("邮箱不存在");
        }
        if (user.getStatus() == 1){
            throw new CustomException("此邮箱已激活");
        }
        if (user.getCheckCode().equals(request.getParameter("checkCode"))){
            user.setStatus(1);
            userMapper.updateByKey(user);
        }else{
            throw new CustomException("身份错误");
        }
    }
}
