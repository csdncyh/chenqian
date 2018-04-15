package com.chenqian.entity;

public class Floor {
    private Integer floorid;
    private Integer articleid;
    private Integer uid;
    private String content;
    private Integer commentid;

    public Integer getFloorid() {
        return floorid;
    }

    public void setFloorid(Integer floorid) {
        this.floorid = floorid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "floor{" +
                "floorid=" + floorid +
                ", articleid=" + articleid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", commentid=" + commentid +
                '}';
    }
}
