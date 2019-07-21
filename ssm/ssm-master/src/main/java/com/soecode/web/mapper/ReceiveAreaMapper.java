package com.soecode.web.mapper;

import com.soecode.web.entity.ReceiveArea;

import java.util.List;

public interface ReceiveAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveArea record);

    int insertSelective(ReceiveArea record);

    List<ReceiveArea> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiveArea record);

    int updateByPrimaryKey(ReceiveArea record);

//    int addReceiverAddress(ReceiveArea receiveArea);
//
//    List<ReceiveArea> chooseReceiverAddress(ReceiveArea receiveArea);
//
//    int updteReceiverAddress(ReceiveArea receiveArea);
}