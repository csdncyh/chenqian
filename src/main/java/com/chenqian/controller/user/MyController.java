package com.chenqian.controller.user;

import com.chenqian.controller.Result;
import com.chenqian.dao.RelationMapper;
import com.chenqian.dao.UserMapper;
import com.chenqian.entity.Article;
import com.chenqian.entity.Relation;
import com.chenqian.entity.SigninToday;
import com.chenqian.entity.User;
import com.chenqian.service.ArticleService;
import com.chenqian.service.RelationService;
import com.chenqian.service.SigninTodayService;
import com.chenqian.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/my")
public class MyController {

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    SigninTodayService signinTodayService;

    @Autowired
    RelationService relationService;

    /**
     * 去主页,返回json格式，前台做重定向
     * @param request
     * @return
     */
    @RequestMapping(value = {"/", ""})
    @ResponseBody
    public Result myUI(HttpServletRequest request) {
        return Result.success("已登陆");
    }


    /**
     * 去个人主页
     * @param request
     * @return
     */
    @RequestMapping(value = {"/myHome"})
    public ModelAndView myHome(HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        User user = (User) request.getSession().getAttribute("user");

        //我的签到信息
        PageHelper.startPage(1,7);
        List<SigninToday> signinTodays = signinTodayService.selectSigninTodayByUid(user.getUid());
        model.addObject("signinTodays", signinTodays);

        //我的帖子
        PageHelper.startPage(1,7);
        List<Article> articles = articleService.selectArticleByUid(user.getUid());
        model.addObject("articles",articles);

        //我的粉丝
        List<Relation> relationIdols = relationService.selectByIdol(user.getUid());
        model.addObject("relationIdols",relationIdols);

        //我的关注
        List<Relation> relationfollowers = relationService.selectByFollower(user.getUid());
        model.addObject("relationfollowers",relationfollowers);

        model.setViewName("user/myHome");
        return model;
    }
}