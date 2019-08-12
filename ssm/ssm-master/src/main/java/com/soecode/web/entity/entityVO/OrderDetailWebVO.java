package com.soecode.web.entity.entityVO;

import com.soecode.web.entity.OrderDetail;

import java.util.Date;
import java.util.List;

public class OrderDetailWebVO {
    private Integer orderId;

    private Integer orderState;

    private Integer goodsNum;

    private Double orderMonery;

    private Date startOrderTime;

    private String payWay;

    private Integer userId;

    private String userName;

    private String userAddr;

    private Integer takePersonId;

    private String takePersonName;

    private Date takeTime;

    private Date sortTime;

    private Date cleanTime;

    private Date deliveryTime;

    private Date getGoodsTime;

    private String PhoneNum;

    private List<OrderDetail> orderDetailList;

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
        this.payWay = payWay;
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
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
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
        this.takePersonName = takePersonName;
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

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
