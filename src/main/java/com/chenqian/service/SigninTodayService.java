package com.chenqian.service;

import com.chenqian.entity.SigninToday;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SigninTodayService {

    List<SigninToday> getSigninTodayAll();

    List<SigninToday> getSigninTodays(int current, int size);

    List<SigninToday> selectSigninTodayByUid(Integer uid);
}