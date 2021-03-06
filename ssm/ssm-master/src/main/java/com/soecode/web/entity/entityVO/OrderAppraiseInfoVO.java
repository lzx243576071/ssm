package com.soecode.web.entity.entityVO;

import java.util.Date;

public class OrderAppraiseInfoVO {
        private Integer id;

        private Integer orderId;

        private Integer userId;

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

        private Date createTime;

        private Date updateTime;

        private String  goodsType;

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    private String classifyName;


        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            goodsType = goodsType;
        }



        public Integer getId() {
        return id;
    }

        public void setId(Integer id) {
        this.id = id;
    }

        public Integer getOrderId() {
        return orderId;
    }

        public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

        public Integer getUserId() {
        return userId;
    }

        public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

        public Date getCreateTime() {
        return createTime;
    }

        public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

        public Date getUpdateTime() {
        return updateTime;
    }

        public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
