package com.soecode.web.mapper;

import com.soecode.web.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface OrderInfoMapper extends Mapper<OrderInfo>{
//    int deleteByPrimaryKey(Integer orderId);

//    int insert(OrderInfo record);
//
//    int insertSelective(OrderInfo record);

//    OrderInfo selectByPrimaryKey(Integer orderId);

    int updateByOrderIdSelective(OrderInfo record);

//    int updateByPrimaryKey(OrderInfo record);

    Integer deleteByOrderId(Integer orderId);

    int insertOrder(OrderInfo record);
}