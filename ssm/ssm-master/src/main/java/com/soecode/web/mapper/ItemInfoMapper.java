package com.soecode.web.mapper;

import com.soecode.web.entity.ItemInfo;
import com.soecode.web.entity.ItemInfoKey;
import com.soecode.web.query.weChatQuery;

import java.util.List;
import java.util.Map;

public interface ItemInfoMapper {
    int deleteByPrimaryKey(ItemInfoKey key);

    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

    ItemInfo selectByPrimaryKey(ItemInfoKey key);

    int updateByPrimaryKeySelective(ItemInfo record);

    int updateByPrimaryKey(ItemInfo record);

    /**
     * 限时抢购商品列表
     * @return
     */
    List<Map<String,Object>> selectXSQGItemList();

    /**
     * 查询加入购物车商品
     * @return
     */
    List<Map<String,Object>> queryItemShopCart(weChatQuery query);
}