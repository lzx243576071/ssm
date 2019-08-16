package com.soecode.web.entity;

import java.util.Date;

public class ReceiveArea {
    private Integer id;                //id

    private Integer userId;            //用户ID
    private String receiverName;    //收货人姓名
    private String address;         //详细地址
    private String phone;           //收货人电话号码
    private String province;        //省
    private String city;            //市
    private String area;            //区
    private String street;          //街道

    private int hasDefault;         //是否默认
    private Date gmtCreate;         //创建时间
    private Date gmtModify;         //修改时间

    public Integer getReceiveInfoId() {
        return receiveInfoId;
    }

    public void setReceiveInfoId(Integer receiveInfoId) {
        this.receiveInfoId = receiveInfoId;
    }

    private Integer receiveInfoId;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getHasDefault() {
        return hasDefault;
    }

    public void setHasDefault(int hasDefault) {
        this.hasDefault = hasDefault;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


}