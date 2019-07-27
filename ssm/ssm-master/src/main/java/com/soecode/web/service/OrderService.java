package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {

    Result getOrderInfo(int userId,int orderStates);

    Result getOrderDetail(int orderId);

    Result cancelOrder(OrderDetail record);
}
