package com.soecode.web.util;


public enum FilePathEnum {


    ITEMIMG("itemimg", "商品图片");



    private String path;

    private String desc;

    FilePathEnum(String path, String desc) {
        this.path = path;
        this.desc = desc;
    }

    public String getPath() {
        return path;
    }

    public String getDesc() {
        return desc;
    }
}
