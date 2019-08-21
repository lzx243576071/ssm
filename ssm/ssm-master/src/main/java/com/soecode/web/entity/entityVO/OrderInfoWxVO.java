package com.soecode.web.entity.entityVO;

import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.ReceiveArea;

import java.util.Date;
import java.util.List;

public class OrderInfoWxVO {
    private Integer orderId;

    private Integer orderState;

    private Integer goodsNum;

    private Double orderMonery;

    private Date startOrderTime;

    private Integer userId;

    private Integer receiveInfoId;

    private List<OrderDetailWxVO> orderDetailWxVOList;

    private ReceiveArea receiveArea;

    public ReceiveArea getReceiveArea() {
        return receiveArea;
    }

    public void setReceiveArea(ReceiveArea receiveArea) {
        this.receiveArea = receiveArea;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<OrderDetailWxVO> getOrderDetailWxVOList() {
        return orderDetailWxVOList;
    }

    public void setOrderDetailWxVOList(List<OrderDetailWxVO> orderDetailWxVOList) {
        this.orderDetailWxVOList = orderDetailWxVOList;
    }
}
