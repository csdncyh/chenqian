package com.chenqian.service;

import com.chenqian.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    /**
     * 获取帖子列表
     * @return
     */
    List<Article> getArticleAll(Integer currently, Integer size);


    /**
     * 获取指定用户的文章
     * @return
     */
    List<Article> selectArticleByUid(Integer uid);
}
