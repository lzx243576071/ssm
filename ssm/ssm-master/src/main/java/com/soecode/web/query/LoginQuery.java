package com.soecode.web.query;

import java.util.Date;

/**
 * Created by Jiangyue on 2019/7/28.
 */
public class LoginQuery {
    private String userId;
    private String openId;
    private String wecahtId;
    private Integer userSex;
    private String headimgUrl;
    private Date  createTime;
    private Date updateTime;

    private Double userAccount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWecahtId() {
        return wecahtId;
    }

    public void setWecahtId(String wecahtId) {
        this.wecahtId = wecahtId;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
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

    public Double getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Double userAccount) {
        this.userAccount = userAccount;
    }

}
