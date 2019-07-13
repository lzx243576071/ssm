package com.soecode.web.entity;

import java.util.Date;

public class AppraiseInfo extends AppraiseInfoKey {
    private String userName;

    private String userMobile;

    private Date startOrderTime;

    private Date appraiseTime;

    private String appraiseContent;

    private String appraiseImg;

    private Double grade;

    private Integer enableShow;

    private Integer appraiseReply;

    private String replyContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Date getStartOrderTime() {
        return startOrderTime;
    }

    public void setStartOrderTime(Date startOrderTime) {
        this.startOrderTime = startOrderTime;
    }

    public Date getAppraiseTime() {
        return appraiseTime;
    }

    public void setAppraiseTime(Date appraiseTime) {
        this.appraiseTime = appraiseTime;
    }

    public String getAppraiseContent() {
        return appraiseContent;
    }

    public void setAppraiseContent(String appraiseContent) {
        this.appraiseContent = appraiseContent == null ? null : appraiseContent.trim();
    }

    public String getAppraiseImg() {
        return appraiseImg;
    }

    public void setAppraiseImg(String appraiseImg) {
        this.appraiseImg = appraiseImg == null ? null : appraiseImg.trim();
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getEnableShow() {
        return enableShow;
    }

    public void setEnableShow(Integer enableShow) {
        this.enableShow = enableShow;
    }

    public Integer getAppraiseReply() {
        return appraiseReply;
    }

    public void setAppraiseReply(Integer appraiseReply) {
        this.appraiseReply = appraiseReply;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}