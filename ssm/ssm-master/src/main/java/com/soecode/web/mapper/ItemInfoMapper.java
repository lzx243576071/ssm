package com.soecode.web.mapper;

import com.soecode.web.entity.ItemInfo;
import com.soecode.web.entity.ItemInfoKey;

import java.util.List;
import java.util.Map;

public interface ItemInfoMapper {
    int deleteByPrimaryKey(ItemInfoKey key);

    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

    ItemInfo selectByPrimaryKey(ItemInfoKey key);

    int updateByPrimaryKeySelective(ItemInfo record);

    int updateByPrimaryKey(ItemInfo record);

    List<Map<String,Object>> selectItemClassifyList();
}