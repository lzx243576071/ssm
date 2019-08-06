package com.soecode.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;


public class MySubscribe extends JedisPubSub {

    public static final Logger logger = LoggerFactory.getLogger(MySubscribe.class);

    // 初始化按表达式的方式订阅时候的处理
    public void onPSubscribe(String pattern, int subscribedChannels) {
        logger.info(pattern + "=" + subscribedChannels);

        System.out.println(pattern + "=" + subscribedChannels);

    }

    // 取得按表达式的方式订阅的消息后的处理
    public void onPMessage(String pattern, String channel, String message) {
        logger.info(pattern + "=" + channel + "=" + message);

        System.out.println(pattern + "=" + channel + "=" + message);
    }

    @Override
    public void onMessage(String channel, String message) {

        System.out.println("  <<< 订阅(SUBSCRIBE)< Channel:" + channel + " >接收到的Message:" + message );
        System.out.println();

        //当接收到的message为quit时，取消订阅(被动方式)
        if(message.equalsIgnoreCase("quit")){
            this.unsubscribe(channel);
        }
    }

}