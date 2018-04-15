package com.chenqian.service.impl;

import com.chenqian.dao.RelationMapper;
import com.chenqian.entity.Relation;
import com.chenqian.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService{

    @Autowired
    RelationMapper relationMapper;
    /**
     * 根据偶像id，
     * @param Idol
     * @return
     */
    @Override
    public List<Relation> selectByIdol(Integer idol) {
        return relationMapper.selectByIdol(idol);
    }

    /**
     * 根据粉丝id获取全部关注的人
     * @param follower
     * @return
     */
    @Override
    public List<Relation> selectByFollower(Integer follower) {
        return relationMapper.selectByFollower(follower);
    }
}
