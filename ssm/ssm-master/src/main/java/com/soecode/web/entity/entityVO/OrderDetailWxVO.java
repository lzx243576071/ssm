package com.soecode.web.entity.entityVO;

import com.soecode.web.entity.GoodsRecord;

import java.util.List;


public class OrderDetailWxVO {
        private Integer id;

        private Integer orderId;

        private Integer goodsId;

        private String goodsName;

        private Double goodsPrice;

        private Integer goodsNum;

        private Double totalPrice;

        private String goodsTexture;

        private String goodsType;

        private String washMethod;

        private List<GoodsRecord> goodsRecordList;

    public List<GoodsRecord> getGoodsRecordList() {
        return goodsRecordList;
    }

    public void setGoodsRecordList(List<GoodsRecord> goodsRecordList) {
        this.goodsRecordList = goodsRecordList;
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

        public Integer getGoodsId() {
        return goodsId;
    }

        public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

        public String getGoodsName() {
        return goodsName;
    }

        public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

        public Double getGoodsPrice() {
        return goodsPrice;
    }

        public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

        public Integer getGoodsNum() {
        return goodsNum;
    }

        public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

        public Double getTotalPrice() {
        return totalPrice;
    }

        public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

        public String getGoodsTexture() {
        return goodsTexture;
    }

        public void setGoodsTexture(String goodsTexture) {
        this.goodsTexture = goodsTexture == null ? null : goodsTexture.trim();
    }

        public String getGoodsType() {
        return goodsType;
    }

        public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

        public String getWashMethod() {
        return washMethod;
    }

        public void setWashMethod(String washMethod) {
        this.washMethod = washMethod == null ? null : washMethod.trim();
    }
}
