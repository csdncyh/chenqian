package com.chenqian.controller;

import com.chenqian.entity.Article;
import com.chenqian.entity.CiBaInfo;
import com.chenqian.entity.SigninToday;
import com.chenqian.entity.User;
import com.chenqian.service.ArticleService;
import com.chenqian.service.PageService;
import com.chenqian.service.SigninTodayService;
import com.chenqian.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PageService pageService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SigninTodayService signinTodayService;

    @Autowired
    private UserService userService;

    /**
     * 去首页
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView goIndex()  {
        //获取词霸近3天的的图片和句子
        List<CiBaInfo> ciBaInfos = new ArrayList<>();
        try {
            ciBaInfos = pageService.getCiBaInfo();
        } catch (IOException e) {
            System.out.println("数据加载异常");
        }
        //获取首页显示的帖子
        List<Article> articleAll = articleService.getArticleAll(1, 5);

        //获取首页今天签到前n个人
        List<SigninToday> signinTodayAll = signinTodayService.getSigninTodays(1, PageConfig.INDEX_NUMBER);

        //获取最近加入的人
        List<User> users = userService.selectAll();
        List<User> userTop5 = new ArrayList<>();
        for (int i=0; i<5; i++){
            if (i >= users.size()){
                break;
            }
            userTop5.add(users.get(i));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ciBaInfos",ciBaInfos);
        modelAndView.addObject("articleAll", articleAll);
        modelAndView.addObject("signinTodayAll", signinTodayAll);
        modelAndView.addObject("userTop5",userTop5);
        modelAndView.setViewName("/index");

        return modelAndView;
    }
}
