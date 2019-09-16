package com.soecode.web.mapper;

import com.soecode.web.entity.ItemInfo;
import com.soecode.web.query.weChatQuery;

import java.util.List;
import java.util.Map;

public interface ItemInfoMapper {

    /**
     * 新增商品
     * @param record
     * @return
     */
    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

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


    /**
     * 查询商品列表(商品名查询)
     * @param query
     * @return
     */
    List<Map<String,Object>> queryByItemName(weChatQuery query);
    /**
     * 查询商品列表（类目季节分类）
     * @param query
     * @return
     */
    List<Map<String,Object>> queryByClassifyId(weChatQuery query);
}