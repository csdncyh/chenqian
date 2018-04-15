package com.chenqian.service.impl;

import com.chenqian.dao.ArticleMapper;
import com.chenqian.entity.Article;
import com.chenqian.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 获取帖子列表
     *
     * @param currently
     * @param size
     * @return
     */
    @Override
    public List<Article> getArticleAll(Integer currently, Integer size) {
        PageHelper.startPage(currently, size);
        List<Article> articleAll = articleMapper.getArticleAll();
        System.out.println(articleAll.size());
//        PageInfo<Article> info = new PageInfo<>(articleAll, 5);
//
        return articleAll;
    }

    /**
     * 获取指定用户的文章
     *
     * @param uid
     * @return
     */
    @Override
    public List<Article> selectArticleByUid(Integer uid) {
        return articleMapper.selectArticleByUid(uid);
    }
}
