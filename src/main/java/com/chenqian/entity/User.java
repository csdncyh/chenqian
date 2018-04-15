package com.chenqian.entity;

import java.util.Date;

public class User {
    private Integer uid;
    private String handImg;
    private Date nearDate;
    private String username;
    private String password;
    private String email;
    private String talk;
    private String score;
    private String checkCode;
    private Integer status;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHandImg() {
        return handImg;
    }

    public void setHandImg(String handImg) {
        this.handImg = handImg;
    }

    public Date getNearDate() {
        return nearDate;
    }

    public void setNearDate(Date nearDate) {
        this.nearDate = nearDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", handImg='" + handImg + '\'' +
                ", nearDate=" + nearDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", talk='" + talk + '\'' +
                ", score='" + score + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", status=" + status +
                '}';
    }
}
