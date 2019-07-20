package com.soecode.web.entity;

import java.util.Date;

public class AccountChange {
    private Integer id;

    private Integer userId;

    private String userName;

    private Double rechargeMoney;

    private Double expenseMoney;

    private Double givenMoney;

    private Double restMoney;

    private Integer orderId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Double getExpenseMoney() {
        return expenseMoney;
    }

    public void setExpenseMoney(Double expenseMoney) {
        this.expenseMoney = expenseMoney;
    }

    public Double getGivenMoney() {
        return givenMoney;
    }

    public void setGivenMoney(Double givenMoney) {
        this.givenMoney = givenMoney;
    }

    public Double getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(Double restMoney) {
        this.restMoney = restMoney;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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