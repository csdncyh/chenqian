package com.chenqian.dao;

import com.chenqian.entity.Floor;

import java.util.List;

public interface FloorMapper {
    List<Floor> getCommentAll();

    Floor getCommentByKey(Integer floorId);
}
