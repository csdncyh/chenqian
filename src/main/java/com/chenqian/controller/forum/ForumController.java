package com.chenqian.controller.forum;

import com.chenqian.entity.Article;
import com.chenqian.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ArticleService articleService;

    /**
     * 论坛页面
     */
    @RequestMapping(value = {"/", ""})
    public ModelAndView goForumUI()  {
        //获取所有帖子列表
        List<Article> articleAll = articleService.getArticleAll(1,15);
        ModelAndView model = new ModelAndView();
        model.addObject("articleAll",articleAll);
        model.setViewName("/forum/forumHome");
        return model;
    }

}