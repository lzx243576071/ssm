package com.soecode.web.message;




public class MessageBean<T> {
    // 响应头文件
    private MessageHeader header;
    // 响应正确内容
    private T body;

    protected MessageBean() {
        header = new MessageHeader();
        header.setRespCode(HeaderCode.RespCode.SUCCESS.getCode());
        header.setRespContent(new HeaderRespContent("", "操作成功"));
    }

    protected MessageBean(HeaderCode.RespCode respCode, HeaderRespContent messageRespContent) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setRespCode(respCode.getCode());
        messageHeader.setRespContent(messageRespContent);
        this.header = messageHeader;
    }

    protected MessageBean(T t) {
       this();
       this.body = t;
    }

    public MessageHeader getHeader() {
        return header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RespBean [head=" + header + ", body=" + body + "]";
    }


}
