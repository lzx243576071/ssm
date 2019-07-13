package com.soecode.web.message;

public class MessageHeader {
    private String respCode;
    private HeaderRespContent respContent;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public HeaderRespContent getRespContent() {
        return respContent;
    }

    public void setRespContent(HeaderRespContent respContent) {
        this.respContent = respContent;
    }


}
