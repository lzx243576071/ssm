package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {

    Result getOrderInfo(Integer userId,Integer orderState);

    Result getOrderDetail(Integer orderId);

    Result updateOrder(OrderDetail record);
}
