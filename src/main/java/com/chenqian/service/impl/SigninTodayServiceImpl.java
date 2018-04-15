package com.chenqian.service.impl;

import com.chenqian.dao.SigninTodayMapper;
import com.chenqian.entity.SigninToday;
import com.chenqian.service.SigninTodayService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SigninTodayServiceImpl implements SigninTodayService{

    @Autowired
    private SigninTodayMapper signinTodayMapper;

    /**
     * 今日全部签到列表
     * @return
     */
    @Override
    public List<SigninToday> getSigninTodayAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        List<SigninToday> signinTodays = signinTodayMapper.getSigninTodayByTime(new Date());
        return signinTodays;
    }

    /**
     * 今日签到列表
     * @return
     */
    @Override
    public List<SigninToday> getSigninTodays(int current, int size) {
        PageHelper.startPage(current, size);
        return this.getSigninTodayAll();
    }

    @Override
    public List<SigninToday> selectSigninTodayByUid(Integer uid) {
        return signinTodayMapper.selectSigninTodayByUid(uid);
    }
}