package com.soecode.web.mapper;

import com.soecode.web.entity.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByPrimaryKey(Integer userId,Integer orderStates);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}