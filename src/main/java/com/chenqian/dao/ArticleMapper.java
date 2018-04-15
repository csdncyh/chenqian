package com.chenqian.dao;

import com.chenqian.entity.Article;

import java.util.List;

public interface ArticleMapper {
    List<Article> getArticleAll();

    List<Article> selectArticleByUid(Integer uid);
}
