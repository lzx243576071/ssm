package com.soecode.web.mapper;

import com.soecode.web.entity.ItemClassify;
import com.soecode.web.entity.ItemClassifyKey;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ItemClassifyMapper extends Mapper<ItemClassify> {
//    int deleteByPrimaryKey(ItemClassifyKey key);
//
//    int insert(ItemClassify record);
//
//    int insertSelective(ItemClassify record);
//
//    ItemClassify selectByPrimaryKey(ItemClassifyKey key);
//
//    int updateByPrimaryKeySelective(ItemClassify record);
//
//    int updateByPrimaryKey(ItemClassify record);

    List<Map<String,Object>> selectItemClassifyList() ;

}