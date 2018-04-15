package com.chenqian.entity;

/**
 * 用户关系
 */
public class Relation {
    private Integer relationid;
    private Integer idol; //偶像id
    private Integer follower; //粉丝id

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    public Integer getIdol() {
        return idol;
    }

    public void setIdol(Integer idol) {
        this.idol = idol;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    @Override
    public String toString() {
        return "relation{" +
                "relationid=" + relationid +
                ", idol=" + idol +
                ", follower=" + follower +
                '}';
    }
}
