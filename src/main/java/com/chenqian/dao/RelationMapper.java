package com.chenqian.dao;

import com.chenqian.entity.Relation;

import java.util.List;

public interface RelationMapper {
    /**
     * 根据偶像id，
     * @param Idol
     * @return
     */
    List<Relation> selectByIdol(Integer idol);

    /**
     * 根据粉丝id获取全部关注的人
     * @param follower
     * @return
     */
    List<Relation> selectByFollower(Integer follower);
}
