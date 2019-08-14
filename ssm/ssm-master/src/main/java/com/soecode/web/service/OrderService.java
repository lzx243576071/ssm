package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {

    Result getOrderInfo(OrderInfo orderInfo,String phoneNum);

    Result getOrderDetail(Integer orderId);

    Result updateOrder(OrderInfo orderInfo, OrderDetail orderDetail);

    Result getWebOrderDetail(Integer orderId);

    Result getOrderInfomations(Integer userId,Integer orderState);
}
