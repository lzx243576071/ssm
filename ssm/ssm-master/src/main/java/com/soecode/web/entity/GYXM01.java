package com.soecode.web.entity;

/**
 * Created by Jiangyue on 2019/6/29.
 * 项目01实体类
 */
public class GYXM01 {
    /**
     * 项目编号
     */
    private Long xmbh;

    /**
     * 是否启用
     */
    private Long sfqy;

    /**
     * 项目名称
     */
    private String xmmc;

    /**
     * 展示图片
     */
    private String zstp;

    public Long getXmbh() {
        return xmbh;
    }

    public void setXmbh(Long xmbh) {
        this.xmbh = xmbh;
    }

    public Long getSfqy() {
        return sfqy;
    }

    public void setSfqy(Long sfqy) {
        this.sfqy = sfqy;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getZstp() {
        return zstp;
    }

    public void setZstp(String zstp) {
        this.zstp = zstp;
    }
}
