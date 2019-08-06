package com.soecode.web.service.impl;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.entityVO.OrderGoodsVO;
import com.soecode.web.mapper.OrderDetailMapper;
import com.soecode.web.mapper.OrderInfoMapper;
import com.soecode.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public Result getOrderInfo(Integer userId,Integer orderState) {
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByPrimaryKey(userId,orderState);
        List<Map<String,Object>>  orderGoodsList = new ArrayList<>();
        for (OrderInfo orderInfo:orderInfoList) {
            Map<String,Object> orderMap = new HashMap<>();
            int orderId = orderInfo.getOrderId();
            List<OrderGoodsVO> orderGoodsVOList = orderDetailMapper.selectDetailByOrderId(orderId);
            orderMap.put("orderInfo",orderInfo);
            orderMap.put("orderGoodsVOList",orderGoodsVOList);
            orderGoodsList.add(orderMap);
        }
        return Result.createSuccessResult(orderGoodsList);
    }

    @Override
    public Result getOrderDetail(Integer orderId) {
        List<OrderGoodsVO> orderGoodsVOreturnList= orderDetailMapper.selectDetailByOrderId(orderId);
        return Result.createSuccessResult(orderGoodsVOreturnList);
    }

    @Override
    public Result updateOrder(OrderDetail record) {
        Result result = Result.createFailResult();
        int icode = orderDetailMapper.updateByPrimaryKeySelective(record);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }
}
