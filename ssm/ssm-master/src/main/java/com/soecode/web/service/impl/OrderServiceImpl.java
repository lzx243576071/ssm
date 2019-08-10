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
    public Result updateOrder(OrderInfo orderInfo, OrderDetail orderDetail) {
        Result result = Result.createFailResult();
        int icode = orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
        if(icode == 0){
            return result.error("更新orderDetail失败");
        }
        if(null != orderDetail.getId()){
            int code = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
            if(code == 0){
                return result.error("更新orderInfo失败");
            }
        }
        return result;
    }
}
