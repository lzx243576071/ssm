package com.soecode.web.service.impl;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.entity.entityVO.OrderDetailWebVO;
import com.soecode.web.entity.entityVO.OrderGoodsVO;
import com.soecode.web.mapper.OrderDetailMapper;
import com.soecode.web.mapper.OrderInfoMapper;
import com.soecode.web.mapper.UserInfoMapper;
import com.soecode.web.service.OrderService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    protected static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public Result getOrderInfo(OrderInfo orderInfo,String phoneNum) {
        if(StringUtils.isNotEmpty(phoneNum)){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserMobile(phoneNum);
            List<UserInfo> userInfoList = userInfoMapper.select(userInfo);
            if(userInfoList.size()>0){
                orderInfo.setUserId(userInfoList.get(0).getUserId());
            }
        }
        List<OrderInfo> orderInfoList = orderInfoMapper.select(orderInfo);
        return Result.createSuccessResult(orderInfoList);
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

    /**
     * 获取web端的订单详情
     * @param orderId
     * @return
     */
    @Override
    public Result<OrderDetailWebVO> getWebOrderDetail(Integer orderId) {
        OrderDetailWebVO orderDetailWebVO = new OrderDetailWebVO();
        OrderInfo orderInfoQuery = new OrderInfo();
        orderInfoQuery.setOrderId(orderId);
        OrderInfo orderInfo = orderInfoMapper.selectOne(orderInfoQuery);
        try {
            BeanUtils.copyProperties(orderInfo, orderDetailWebVO);
        }catch (Exception e){
            logger.error("orderDetailWebVO copyProperties error e:{}",e);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(orderInfo.getUserId());
        UserInfo userInfoForPhone = userInfoMapper.selectOne(userInfo);
        orderDetailWebVO.setPhoneNum(userInfoForPhone.getUserMobile());
        return Result.createSuccessResult(orderDetailWebVO);
    }
}
