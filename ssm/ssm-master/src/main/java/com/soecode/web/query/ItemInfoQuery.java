package com.soecode.web.query;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class ItemInfoQuery {
    private Integer itemId;

    private String itemName;

    private Integer classifyId;

    private String classifyName;

    private Double itemPrice;

    private String goodsTexture;

    private Integer season;

    private String washMethod;

    private transient List<MultipartFile> itemImg;

    private String oldItemImg;

    private Integer joinActivities;

    private Date createTime;

    private Date updateTime;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getGoodsTexture() {
        return goodsTexture;
    }

    public void setGoodsTexture(String goodsTexture) {
        this.goodsTexture = goodsTexture == null ? null : goodsTexture.trim();
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getWashMethod() {
        return washMethod;
    }

    public void setWashMethod(String washMethod) {
        this.washMethod = washMethod == null ? null : washMethod.trim();
    }

    public List<MultipartFile> getItemImg() {
        return itemImg;
    }

    public void setItemImg(List<MultipartFile> itemImg) {
        this.itemImg = itemImg == null ? null : itemImg;
    }

    public String getOldItemImg() {
        return oldItemImg;
    }

    public void setOldItemImg(String oldItemImg) {
        this.oldItemImg = oldItemImg == null ? null : oldItemImg.trim();
    }

    public Integer getJoinActivities() {
        return joinActivities;
    }

    public void setJoinActivities(Integer joinActivities) {
        this.joinActivities = joinActivities;
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