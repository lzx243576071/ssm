package com.soecode.web.service;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.query.weChatQuery;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiangyue on 2019/6/29.
 */
public interface WeChatService {

   Result queryoneKeyOrderList(weChatQuery query);

   Result queryItemList(weChatQuery query);

   Result addShopCart(weChatQuery query);

   Result queryShopCart(Integer userId);

   Result queryDefaultReceiveArea(weChatQuery query);

   Result queryAppointmentTime(weChatQuery query) throws ParseException;

   Result submitOrder(OrderInfo queryOI,OrderDetail queryOD,String shopId);

   Result deleteShopCart(String shopId) ;

   Result queryPrice(String shopId);
}
