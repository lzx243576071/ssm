package com.soecode.web.service;


import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.query.weChatQuery;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by Jiangyue on 2019/6/29.
 */
public interface WeChatService {

   Map<String,Object> queryoneKeyOrderList();

   Map<String,Object> queryItemList(weChatQuery query);

   Map<String,Object> addShopCart(weChatQuery query) throws ParseException;

   Map<String,Object> queryShopCart(Integer userId);

   Map<String,Object>  queryDefaultReceiveArea(weChatQuery query);

   void submitOrder(OrderInfo queryOI,OrderDetail queryOD) throws ParseException;
}
