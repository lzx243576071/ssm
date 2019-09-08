package com.soecode.web.entity;

import java.util.Date;

public class ModuleFunc {
    private Integer moduleId;

    private String moduleName;

    private Integer parentId;

    private String modualurl;

    private Integer modualorder;

    private Integer isbutton;

    private Integer funcid;

    private Date createTime;

    private Date updateTime;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getModualurl() {
        return modualurl;
    }

    public void setModualurl(String modualurl) {
        this.modualurl = modualurl == null ? null : modualurl.trim();
    }

    public Integer getModualorder() {
        return modualorder;
    }

    public void setModualorder(Integer modualorder) {
        this.modualorder = modualorder;
    }

    public Integer getIsbutton() {
        return isbutton;
    }

    public void setIsbutton(Integer isbutton) {
        this.isbutton = isbutton;
    }

    public Integer getFuncid() {
        return funcid;
    }

    public void setFuncid(Integer funcid) {
        this.funcid = funcid;
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