package com.soecode.web.mapper;

import com.soecode.web.entity.ShopCartInfo;
import com.soecode.web.query.weChatQuery;

import java.util.List;
import java.util.Map;

public interface ShopCartInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(weChatQuery query);

    int insertSelective(ShopCartInfo record);

    ShopCartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCartInfo record);

    int updateByPrimaryKey(ShopCartInfo record);

    List<Map<String,Object>> queryShopCart(weChatQuery query);

    Map<String,Object> queryUserId(weChatQuery query);
}