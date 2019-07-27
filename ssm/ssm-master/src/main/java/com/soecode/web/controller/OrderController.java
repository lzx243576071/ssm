package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/common/getOrderInfo")
    public Result getOrderInfo(HttpServletRequest request,int userId,int orderStates) {
        return orderService.getOrderInfo(userId,orderStates);
    }


    @RequestMapping(value = "/common/getOrderDetail")
    public Result getOrderDetail(HttpServletRequest request,int OrderId) {
        return orderService.getOrderDetail(OrderId);
    }

    @RequestMapping(value = "/common/cancelOrder")
    public Result cancelOrder(HttpServletRequest request, OrderDetail record) {
        return orderService.cancelOrder(record);
    }
}
