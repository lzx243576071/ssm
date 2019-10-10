package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.entity.entityVO.OrderDetailWebVO;
import com.soecode.web.entity.entityVO.OrderInfoWxVO;
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
import java.util.List;

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
     * 获取订单详情
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
     * @param orderDetailList
     * @return
     */
    @RequestMapping(value = "/common/updateOrder")
    public Result updateOrder(OrderInfo orderInfo, List<OrderDetail> orderDetailList) {
        if(null == orderInfo.getOrderId()){
            return Result.createFailResult("orderId不能為空");
        }
        return orderService.updateOrder(orderInfo,orderDetailList);
    }

    /**
     * 获取微信订单明细（我的订单）
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = "/wx/getOrderInfomations")
    public Result<List<OrderInfoWxVO>> getOrderInfomations(OrderInfo orderInfo) {
        if(null == orderInfo.getUserId() || orderInfo.getUserId()==0){
            return Result.createFailResult().error("缺少必要参数userId");
        }
        return orderService.getOrderInfomations(orderInfo);
    }

    /**
     * 获取微信订单详情
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = "/wx/getOrderDetailInfomation")
    public Result<List<OrderInfoWxVO>> getOrderDetailInfomation(OrderInfo orderInfo) {
        if(null == orderInfo.getOrderId() || orderInfo.getOrderId()==0){
            return Result.createFailResult().error("缺少必要参数orderId");
        }
        return orderService.getOrderDetailInfomation(orderInfo);
    }

    /**
     * 获取用户管理后台订单明细
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/web/getOrderDetail")
    public Result<OrderDetailWebVO> getWebOrderDetail(Integer orderId) {
        if(null == orderId || orderId==0){
            return Result.createFailResult().error("缺少必要参数orderId");
        }
        return orderService.getWebOrderDetail(orderId);
    }

    /**
     * 添加评论
     * @param appraiseInfo
     * @return
     */
    @RequestMapping(value = "/wx/addOrderAppraise")
    public Result addOrderAppraise(AppraiseInfo appraiseInfo) {
        Result result = Result.createFailResult();
        if(null == appraiseInfo.getOrderId() || appraiseInfo.getOrderId() ==0){
            return result.error("缺少必要参数orderId");
        }
        if(null == appraiseInfo.getUserId() || appraiseInfo.getUserId() ==0 ){
            return result.error("缺少必要参数userId");
        }
        return orderService.addOrderAppraise(appraiseInfo);
    }

    /**
     * 删除订单
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/common/deleteOrder")
    public Result deleteOrder(HttpServletRequest request,Integer orderId) {
        if(null==orderId || orderId==0){
            return Result.createFailResult("缺少必要参数orderId");
        }
        return orderService.deleteOrder(orderId);
    }

}
