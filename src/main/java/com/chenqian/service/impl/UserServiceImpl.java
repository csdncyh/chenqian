package com.chenqian.service.impl;

import com.chenqian.dao.UserMapper;
import com.chenqian.entity.User;
import com.chenqian.exception.CustomException;
import com.chenqian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByID(Integer uid) {
        userMapper.selectByKey(uid);
        return null;
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByEmail(String email) throws CustomException {
        return userMapper.selectByEmail(email);
    }

    @Override
    public void updateByID(User user) {
        userMapper.updateByKey(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
