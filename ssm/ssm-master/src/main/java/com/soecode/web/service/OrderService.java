package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.entityVO.OrderDetailWebVO;
import com.soecode.web.entity.entityVO.OrderInfoWxVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {

    Result getOrderInfo(OrderInfo orderInfo,String phoneNum);

    Result getOrderDetail(Integer orderId);

    Result updateOrder(OrderInfo orderInfo, OrderDetail orderDetail);

    Result<OrderDetailWebVO> getWebOrderDetail(Integer orderId);

    Result<List<OrderInfoWxVO>> getOrderInfomations(Integer userId, Integer orderState);

    Result addOrderAppraise(AppraiseInfo appraiseInfo);
}
