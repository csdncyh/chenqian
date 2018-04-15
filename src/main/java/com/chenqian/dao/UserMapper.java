package com.chenqian.dao;

import com.chenqian.entity.User;

import java.util.List;

public interface UserMapper {
    User selectByKey(Integer uid);

    List<User> selectAll();

    User selectByUserName(String username);

    void insert(User user);

    User selectByEmail(String email);

    void updateByKey(User user);
}
