package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.OrderDetail;
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
     * 获取订单详情
     * @param request
     * @param orderState
     * @return
     */
    @RequestMapping(value = "/common/getOrderInfo")
    public Result getOrderInfo(HttpServletRequest request,Integer orderState) {
        Result result = Result.createFailResult();
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        int userId = 0;
//        Boolean cookieBoolean = false;
//        for (Cookie cookie : cookies) {
//            if(session.getId()==cookie.getValue()){
//                cookieBoolean=true;
//            }
//        }
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("uid")){
                    userId = Integer.parseInt(cookie.getValue());
                }
            }
//        if(session.getAttribute(Constants.WEB_SESSSION_ID_KEY) == null){
//            return result.error(ResultCodeEnums.NOT_LOGIN);
//        }
//        int userId = (Integer) session.getAttribute(Constants.WEB_SESSSION_ID_KEY);
        if(userId == 0){
            result.error(ResultCodeEnums.NOT_LOGIN);
            return result;
        }
        return orderService.getOrderInfo(userId,orderState);
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
     * @param request
     * @param record
     * @return
     */
    @RequestMapping(value = "/common/updateOrder")
    public Result updateOrder(HttpServletRequest request, OrderDetail record) {
        return orderService.updateOrder(record);
    }
}
