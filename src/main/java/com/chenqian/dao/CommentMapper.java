package com.chenqian.dao;

import com.chenqian.entity.Comment;

import java.util.List;

public interface CommentMapper {

    List<Comment> getCommentAll();

    Comment getCommentByKey(Integer commentId);
}
