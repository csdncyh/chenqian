package com.chenqian.service;

import com.chenqian.entity.User;
import com.chenqian.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User getUserByID(Integer uid);
    User getUserByName(String username);

    void insert(User user);

    User selectByEmail(String email) throws CustomException;

    void updateByID(User user);

    List<User> selectAll();
}
