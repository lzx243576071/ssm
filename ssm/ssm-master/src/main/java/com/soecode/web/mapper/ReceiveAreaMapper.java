package com.soecode.web.mapper;

import com.soecode.web.entity.ReceiveArea;
import com.soecode.web.query.weChatQuery;

import java.util.List;
import java.util.Map;

public interface ReceiveAreaMapper {

   int addReceiverAddress(ReceiveArea receiveArea);

    List chooseReceiverAddress(ReceiveArea receiveArea);

    int updteReceiverAddress(ReceiveArea receiveArea);

    int deleteReceiverAddress(ReceiveArea receiveArea);

    int updateHasDefault(ReceiveArea receiveArea);


 Map<String,Object> queryDefaultReceiveArea(weChatQuery query);
}