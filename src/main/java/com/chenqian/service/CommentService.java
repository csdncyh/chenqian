package com.chenqian.service;

import com.chenqian.entity.Comment;

import java.util.Date;
import java.util.List;

/**
 * 评论
 */
public interface CommentService {
    /**
     * 获取指定帖子的评论列表
     * @return
     */
    List<Comment> getCommentAll(Integer articleId);
}
