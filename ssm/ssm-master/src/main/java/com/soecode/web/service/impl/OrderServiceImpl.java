package com.soecode.web.service.impl;


import com.alipay.api.domain.GoodsSafetyInventory;
import com.eimageglobal.common.utils.common.lang.SystemUtil;
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

import java.util.*;

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

    @Autowired
    private AppraiseInfoMapper appraiseInfoMapper;

    @Autowired
    private ReceiveAreaMapper receiveAreaMapper;


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
        orderInfo.setUpdateTime(new Date());
        int icode = orderInfoMapper.updateByOrderIdSelective(orderInfo);
        if(icode == 0){
            return result.error("更新orderInfo失败");
        }else{
            result = Result.createSuccessResult();
        }
        if(null !=orderDetail && null!= orderDetail.getId()){
            orderDetail.setUpdateTime(new Date());
            int code = orderDetailMapper.updateByIdSelective(orderDetail);
            if(code == 0){
                return result.error("更新orderDetail失败");
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
     * @param orderInfoDO
     * @return
     */
    @Override
    public Result<List<OrderInfoWxVO>> getOrderInfomations(OrderInfo orderInfoDO) {
        Result result = Result.createFailResult();
        List<OrderInfoWxVO> orderInfoWxVOlist = new ArrayList<>();
//        OrderInfo orderInfoQuery = new OrderInfo();
//        orderInfoQuery.setUserId(orderInfoDO.getUserId());
//        if(null!=orderInfoDO.getOrderState() || orderInfoDO.getOrderState()==0){
//            orderInfoQuery.setOrderState(orderInfoDO.getOrderState());
//        }
        //获取订单列表
        List<OrderInfo> orderInfoList = orderInfoMapper.select(orderInfoDO);
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
                if(null != itemClassifyList.get(0).getClassifyImg()) {
                    orderDetailWxVO.setImg(itemClassifyList.get(0).getClassifyImg());
                }
                orderDetailWxVOList.add(orderDetailWxVO);
            }
            orderInfoWxVO.setOrderDetailWxVOList(orderDetailWxVOList);
            orderInfoWxVOlist.add(orderInfoWxVO);
        }

        return Result.createSuccessResult(orderInfoWxVOlist);
    }

    @Override
    public Result getOrderDetailInfomation(OrderInfo orderInfoDO) {
        Result<List<OrderInfoWxVO>> orderInfoWxVOListResult = getOrderInfomations(orderInfoDO);
        List<OrderInfoWxVO> orderInfoWxVOList = orderInfoWxVOListResult.getData();
        OrderInfoWxVO orderInfoWxVO = orderInfoWxVOList.get(0);
        ReceiveArea receiveAreaQuery = new ReceiveArea();
        receiveAreaQuery.setId(orderInfoWxVO.getReceiveInfoId());
        ReceiveArea receiveArea = receiveAreaMapper.selectOne(receiveAreaQuery);
        orderInfoWxVO.setReceiveArea(receiveArea);
        return Result.createSuccessResult(orderInfoWxVO);
    }

    @Override
    public Result addOrderAppraise(AppraiseInfo appraiseInfo) {
        Result result = Result.createFailResult();
        UserInfo userInfoQuery = new UserInfo();
        userInfoQuery.setUserId(appraiseInfo.getUserId());
        UserInfo userInfo = userInfoMapper.selectOne(userInfoQuery);
        if(null == userInfo){
            result.error("查询不到用户信息");
        }
        appraiseInfo.setUserName(userInfo.getUserName());
        appraiseInfo.setUserMobile(userInfo.getUserMobile());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        OrderInfo orderInfoQuery = new OrderInfo();
        orderInfoQuery.setOrderId(appraiseInfo.getOrderId());
        OrderInfo orderInfo = orderInfoMapper.selectOne(orderInfoQuery);
        if(null == orderInfo){
            result.error("查询不到订单信息");
        }
        appraiseInfo.setStartOrderTime(orderInfo.getStartOrderTime());
        appraiseInfo.setAppraiseTime(new Date());
        int icode = appraiseInfoMapper.insertSelective(appraiseInfo);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result.error("插入失败");
    }

    @Override
    public Result deleteOrder(Integer orderId) {
        Result result = Result.createSuccessResult();
        int icodeInfo = orderInfoMapper.deleteByOrderId(orderId);
        int icodeDetail = orderDetailMapper.deleteByOrderId(orderId);
        if(icodeInfo==0){
            return result.error("订单删除失败orderInfo");
        }
        if(icodeDetail==0){
            return result.error("订单删除失败orderDetail");
        }
        return result;
    }
}
