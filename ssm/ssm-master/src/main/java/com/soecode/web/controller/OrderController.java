package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.service.OrderService;
import com.soecode.web.util.constants.Constants;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(WXCheckController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单列表
     * @return
     */
    @RequestMapping(value = "/web/getOrderInfo")
    public Result getOrderInfo(OrderInfo orderInfo,String phoneNum) {
        Result result = Result.createFailResult();
        return orderService.getOrderInfo(orderInfo,phoneNum);
    }


    /**
     * 获取订单明细
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/common/getOrderDetail")
    public Result getOrderDetail(HttpServletRequest request,Integer orderId) {
        return orderService.getOrderDetail(orderId);
    }

    /**
     * 更改订单
     * @param orderInfo
     * @param orderDetail
     * @return
     */
    @RequestMapping(value = "/common/updateOrder")
    public Result updateOrder(OrderInfo orderInfo, OrderDetail orderDetail) {
        if(null == orderInfo.getOrderId()){
            return Result.createFailResult("orderId不能為空");
        }
        return orderService.updateOrder(orderInfo,orderDetail);
    }

    /**
     * 获取订单明细
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/web/getOrderDetail")
    public Result getWebOrderDetail(Integer orderId) {
        if(null == orderId || orderId==0){
            return Result.createFailResult().error("缺少必要参数orderId");
        }
        return orderService.getWebOrderDetail(orderId);
    }
}
