package com.soecode.web.message;



public class MessageClient {

    public static <T> MessageBean<T> createMessage() {
        MessageBean<T> messageBean = new MessageBean<T>();
        return messageBean;
    }

    public static <T> MessageBean<T> createMessage(HeaderCode.RespCode respCode, HeaderRespContent messageRespContent) {
        MessageBean<T> messageBean = new MessageBean<T>(respCode, messageRespContent);
        return messageBean;
    }

    public static <T> MessageBean<T> createMessage(T t) {
        return new MessageBean<T>(t);
    }
  
}
