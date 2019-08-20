package com.soecode.web.mapper;

import com.soecode.web.entity.ItemClassify;
import com.soecode.web.entity.ItemClassifyKey;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ItemClassifyMapper extends Mapper<ItemClassify> {

    List<Map<String,Object>> selectItemClassifyList() ;

}