package com.soecode.web.entity;

public class ItemClassify{
    private String classifyName;

    private String classifyImg;

    private Integer enable;

    private Integer classifyId;

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

    public String getClassifyImg() {
        return classifyImg;
    }

    public void setClassifyImg(String classifyImg) {
        this.classifyImg = classifyImg == null ? null : classifyImg.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}