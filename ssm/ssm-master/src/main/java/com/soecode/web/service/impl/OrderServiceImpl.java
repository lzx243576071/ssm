package com.soecode.web.service.impl;


import com.alipay.api.domain.GoodsSafetyInventory;
import com.soecode.web.dto.Result;
import com.soecode.web.entity.*;
import com.soecode.web.entity.entityVO.OrderDetailWebVO;
import com.soecode.web.entity.entityVO.OrderDetailWxVO;
import com.soecode.web.entity.entityVO.OrderGoodsVO;
import com.soecode.web.entity.entityVO.OrderInfoWxVO;
import com.soecode.web.mapper.*;
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

    @Autowired
    private GoodsRecordMapper goodsRecordMapper;

    @Autowired
    private ItemClassifyMapper itemClassifyMapper;


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

    /**
     * 获取微信订单明细
     * @param userId
     * @param orderState
     * @return
     */
    @Override
    public Result getOrderInfomations(Integer userId, Integer orderState) {
        Result result = Result.createFailResult();
        List<OrderInfoWxVO> orderInfoWxVOlist = new ArrayList<>();
        OrderInfo orderInfoQuery = new OrderInfo();
        orderInfoQuery.setUserId(userId);
        if(null!=orderState || orderState==0){
            orderInfoQuery.setOrderState(orderState);
        }
        //获取订单列表
        List<OrderInfo> orderInfoList = orderInfoMapper.select(orderInfoQuery);
        if(orderInfoList.size()==0){
            result.value("该用户没有订单信息");
        }
        for (OrderInfo orderInfo:orderInfoList) {
            OrderDetail orderDetailQuery = new OrderDetail();
            orderDetailQuery.setOrderId(orderInfo.getOrderId());
            //获取订单详情
            List<OrderDetail> orderDetailList = orderDetailMapper.select(orderDetailQuery);
            if(orderDetailList.size()==0){
                result.value("该用户没有订单详情信息");
            }
            OrderInfoWxVO orderInfoWxVO = new OrderInfoWxVO();
            BeanUtils.copyProperties(orderInfo,orderInfoWxVO);
            List<OrderDetailWxVO> orderDetailWxVOList = new ArrayList<>();
            for (OrderDetail orderDetail:orderDetailList) {
                OrderDetailWxVO orderDetailWxVO = new OrderDetailWxVO();
                ItemClassify itemClassifyQuery = new ItemClassify();
                itemClassifyQuery.setClassifyId(orderDetail.getGoodsState());
                List<ItemClassify> itemClassifyList = itemClassifyMapper.select(itemClassifyQuery);
                orderDetail.setGoodsType(itemClassifyList.get(0).getClassifyName());
                BeanUtils.copyProperties(orderDetail,orderDetailWxVO);
                GoodsRecord goodsRecordQuery = new GoodsRecord();
                goodsRecordQuery.setOrderId(orderDetail.getOrderId());
                goodsRecordQuery.setGoodsId(orderDetail.getGoodsId());
                //获取订单状态更改信息
                List<GoodsRecord> goodsRecordList = goodsRecordMapper.select(goodsRecordQuery);
                if(goodsRecordList.size()>0) {
                    orderDetailWxVO.setGoodsRecordList(goodsRecordList);
                }
                orderDetailWxVOList.add(orderDetailWxVO);
            }
            orderInfoWxVO.setOrderDetailWxVOList(orderDetailWxVOList);
            orderInfoWxVOlist.add(orderInfoWxVO);
        }

        return Result.createSuccessResult(orderInfoWxVOlist);
    }
}
