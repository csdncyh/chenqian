package com.chenqian.entity;

import java.util.Date;

/**
 * 评论
 */
public class Comment {
    private Integer  commentid;
    private String content ;
    private Integer articleid;
    private Integer uid;
    private Date date;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", content='" + content + '\'' +
                ", articleid=" + articleid +
                ", uid=" + uid +
                ", date=" + date +
                '}';
    }
}
