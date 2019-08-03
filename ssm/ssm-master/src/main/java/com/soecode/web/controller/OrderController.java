package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.service.OrderService;
import com.soecode.web.util.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单详情
     * @param request
     * @param orderStates
     * @return
     */
    @RequestMapping(value = "/common/getOrderInfo")
    public Result getOrderInfo(HttpServletRequest request,int orderStates) {
        Result result = Result.createFailResult();
        HttpSession session = request.getSession();
        if(session.getAttribute(Constants.WEB_SESSSION_ID_KEY) == null){
            result.value(ResultCodeEnums.NOT_LOGIN);
            return result;
        }
        int userId = (Integer) session.getAttribute(Constants.WEB_SESSSION_ID_KEY);
        if(userId == 0){
            result.value(ResultCodeEnums.NOT_LOGIN);
            return result;
        }
        return orderService.getOrderInfo(userId,orderStates);
    }


    /**
     * 获取订单明细
     * @param request
     * @param OrderId
     * @return
     */
    @RequestMapping(value = "/common/getOrderDetail")
    public Result getOrderDetail(HttpServletRequest request,int OrderId) {
        return orderService.getOrderDetail(OrderId);
    }

    /**
     * 更改订单
     * @param request
     * @param record
     * @return
     */
    @RequestMapping(value = "/common/updateOrder")
    public Result updateOrder(HttpServletRequest request, OrderDetail record) {
        return orderService.updateOrder(record);
    }
}
