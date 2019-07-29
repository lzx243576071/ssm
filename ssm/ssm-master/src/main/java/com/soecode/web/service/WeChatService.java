package com.soecode.web.service;


import com.soecode.web.query.weChatQuery;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by Jiangyue on 2019/6/29.
 */
public interface WeChatService {

   Map<String,Object> queryoneKeyOrderList();

   void addShopCart(weChatQuery query) throws ParseException;

   Map<String,Object> queryShopCart(weChatQuery query);



}
