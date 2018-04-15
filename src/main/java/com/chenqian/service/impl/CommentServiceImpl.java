package com.chenqian.service.impl;

import com.chenqian.entity.Comment;
import com.chenqian.service.CommentService;

import java.util.Date;
import java.util.List;

/**
 * 评论
 */
public class CommentServiceImpl implements CommentService{

    /**
     * 获取指定帖子的评论列表
     *
     * @param articleId
     * @return
     */
    @Override
    public List<Comment> getCommentAll(Integer articleId) {
        return null;
    }
}
