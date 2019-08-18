package com.soecode.web.entity;

import java.io.Serializable;
import java.util.Date;

public class SystemInfo implements Serializable {


    private Integer sysId;

    private String sysUserName;

    private String sysUserPassword;

    private Integer roleId;

    private String sysName;

    private String sysUserMobile;

    private Date createTime;

    private Date updateTime;

    private String remarks;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName == null ? null : sysUserName.trim();
    }

    public String getSysUserPassword() {
        return sysUserPassword;
    }

    public void setSysUserPassword(String sysUserPassword) {
        this.sysUserPassword = sysUserPassword == null ? null : sysUserPassword.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysUserMobile() {
        return sysUserMobile;
    }

    public void setSysUserMobile(String sysUserMobile) {
        this.sysUserMobile = sysUserMobile == null ? null : sysUserMobile.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}