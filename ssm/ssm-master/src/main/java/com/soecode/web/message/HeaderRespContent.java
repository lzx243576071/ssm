package com.soecode.web.message;

public class HeaderRespContent {
    private String code = "";
    private String text = "";

    public HeaderRespContent(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

}
