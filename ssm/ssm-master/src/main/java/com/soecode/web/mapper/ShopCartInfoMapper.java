package com.soecode.web.mapper;

import com.soecode.web.entity.ShopCartInfo;
import com.soecode.web.query.LoginQuery;
import com.soecode.web.query.weChatQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShopCartInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(weChatQuery query);

    int insertSelective(ShopCartInfo record);

    ShopCartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCartInfo record);

    int updateByPrimaryKey(ShopCartInfo record);

    List<Map<String,Object>> queryShopCart(@Param("userId") Integer userId);

    Map<String,Object> queryUserId(LoginQuery query);

    int updateShopCartState(@Param("userId")Integer userId,@Param("itemId") Integer itemId);

    int updateItemNum(@Param("id")Integer id,@Param("num") Integer num);

    Map<String, Object> queryItemNum(Integer id);

    void deleteShopCart(List<String> id);

    Map<String, Object> queryPrice(int id2);

    List<Map<String, Object>> querySubmitItem(List<String> id );
}