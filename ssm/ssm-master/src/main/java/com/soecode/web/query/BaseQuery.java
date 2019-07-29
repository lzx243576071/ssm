package com.soecode.web.query;

import java.util.List;

/**
 * 查询基类
 * @author Young
 * @date 2017/10/23
 */
public abstract class BaseQuery {

    private static final int DEFAULT_PAGE_SIZE = 20;

    protected int pageNum = 1;

    protected int pageSize = DEFAULT_PAGE_SIZE;

    private String startDate;

    private String endDate;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSizeOrDefault() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "BaseQuery{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

}
