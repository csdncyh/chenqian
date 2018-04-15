package com.chenqian.interceptor;

import com.chenqian.controller.Result;
import com.chenqian.entity.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * 拦截器
 */
public class interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入111");
//        HandlerMethod handlerMethod = (HandlerMethod)handler;
//        String methodName = handlerMethod.getMethod().getName();
//        String className = handlerMethod.getClass().getName();
//
//        /**
//         * 解析控制器方法
//         */
//        StringBuffer buff = new StringBuffer();
//        Map paramMap = request.getParameterMap();
//        Iterator it = paramMap.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry entry = (Map.Entry)it.next();
//            String mapKey = (String)entry.getKey();
//            String mapVaule = "";
//
//            Object obj = entry.getValue();
//            if (obj instanceof String[]){
//                String[] strs = (String[])obj;
//                mapVaule = Arrays.toString(strs);
//            }
//            buff.append(mapKey).append("=").append(mapVaule);
//        }

        /**
         * 判断用户是否已经登录
         */
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //没有登录， 通过HttpServletResponse返回json数据, 不走控制器
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(Result.error("未登录").toString());
            System.out.println("没有登录");
            out.flush();
            out.close();
            return false;
        }
        System.out.println("登录了");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    //第三个参数表示的是控制层被拦截的方法


}
