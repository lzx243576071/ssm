package com.soecode.web.entity;

import java.util.Date;

public class OrderInfo {
    private Integer orderId;

    private Integer orderState;

    private Integer goodsNum;

    private Double orderMonery;

    private Date startOrderTime;

    private String payWay;

    private Integer userId;

    private String userName;

    private Integer receiveInfoId;

    private Integer takePersonId;

    private String takePersonName;

    private Date takeTime;

    private Date sortTime;

    private Date cleanTime;

    private Date deliveryTime;

    private Date getGoodsTime;

    private String commission;

    private String remarks;

    private Date createTime;

    private Date updateTime;

    private String appointmentTime;

    public Integer getReceiveInfoId() {
        return receiveInfoId;
    }

    public void setReceiveInfoId(Integer receiveInfoId) {
        this.receiveInfoId = receiveInfoId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getOrderMonery() {
        return orderMonery;
    }

    public void setOrderMonery(Double orderMonery) {
        this.orderMonery = orderMonery;
    }

    public Date getStartOrderTime() {
        return startOrderTime;
    }

    public void setStartOrderTime(Date startOrderTime) {
        this.startOrderTime = startOrderTime;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
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

    public Integer getTakePersonId() {
        return takePersonId;
    }

    public void setTakePersonId(Integer takePersonId) {
        this.takePersonId = takePersonId;
    }

    public String getTakePersonName() {
        return takePersonName;
    }

    public void setTakePersonName(String takePersonName) {
        this.takePersonName = takePersonName == null ? null : takePersonName.trim();
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }

    public Date getSortTime() {
        return sortTime;
    }

    public void setSortTime(Date sortTime) {
        this.sortTime = sortTime;
    }

    public Date getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(Date cleanTime) {
        this.cleanTime = cleanTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getGetGoodsTime() {
        return getGoodsTime;
    }

    public void setGetGoodsTime(Date getGoodsTime) {
        this.getGoodsTime = getGoodsTime;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission == null ? null : commission.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime == null ? null : appointmentTime.trim();
    }
}