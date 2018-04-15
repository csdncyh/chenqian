package com.chenqian.dao;

import com.chenqian.entity.SigninToday;

import java.util.Date;
import java.util.List;

/**
 * 签到
 */
public interface SigninTodayMapper {
    /**
     * 今日签到列表
     * @param time
     * @return
     */
    List<SigninToday> getSigninTodayByTime(Date time);

    /**
     * 获取全部签到
     * @return
     */
    List<SigninToday> getSigninTodayAll();

    /**
     * 根据用户获取签到
     * @param uid
     * @return
     */
    List<SigninToday> selectSigninTodayByUid(Integer uid);
}
