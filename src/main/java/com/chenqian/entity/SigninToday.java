package com.chenqian.entity;

import java.util.Date;
import java.util.List;

/**
 * 今日签到记录
 */
public class SigninToday {

    private Integer signinTodayId;
    private Integer uid;
    private Date time;
    private Integer status;
    private String mydesc;

    public Integer getSigninTodayId() {
        return signinTodayId;
    }

    public void setSigninTodayId(Integer signinTodayId) {
        this.signinTodayId = signinTodayId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMydesc() {
        return mydesc;
    }

    public void setMydesc(String mydesc) {
        this.mydesc = mydesc;
    }

    @Override
    public String toString() {
        return "SigninToday{" +
                "signinTodayId=" + signinTodayId +
                ", uid=" + uid +
                ", time=" + time +
                ", status=" + status +
                ", mydesc='" + mydesc + '\'' +
                '}';
    }
}
