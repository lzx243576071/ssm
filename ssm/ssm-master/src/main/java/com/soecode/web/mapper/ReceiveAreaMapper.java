package com.soecode.web.mapper;

import com.soecode.web.entity.ReceiveArea;

import java.util.List;

public interface ReceiveAreaMapper {

   int addReceiverAddress(ReceiveArea receiveArea);

    List chooseReceiverAddress(ReceiveArea receiveArea);

    int updteReceiverAddress(ReceiveArea receiveArea);

    int deleteReceiverAddress(ReceiveArea receiveArea);

    int updateHasDefault(ReceiveArea receiveArea);
}