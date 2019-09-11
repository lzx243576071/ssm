package com.soecode.web.service;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.query.weChatQuery;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by Jiangyue on 2019/6/29.
 */
public interface WeChatService {

   Result queryoneKeyOrderList();

   Result queryItemList(weChatQuery query);

   Result addShopCart(weChatQuery query) throws ParseException;

   Result queryShopCart(Integer userId);

   Result  queryDefaultReceiveArea(weChatQuery query);

   Result submitOrder(OrderInfo queryOI,OrderDetail queryOD) throws ParseException;
}
