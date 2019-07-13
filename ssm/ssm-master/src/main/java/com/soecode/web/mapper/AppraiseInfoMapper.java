package com.soecode.web.mapper;

import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.AppraiseInfoKey;

import java.util.List;
import java.util.Map;

public interface AppraiseInfoMapper {
    int deleteByPrimaryKey(AppraiseInfoKey key);

    int insert(AppraiseInfo record);

    int insertSelective(AppraiseInfo record);

    AppraiseInfo selectByPrimaryKey(AppraiseInfoKey key);

    int updateByPrimaryKeySelective(AppraiseInfo record);

    int updateByPrimaryKey(AppraiseInfo record);

List<Map<String,Object>>selectAppraiseList();
}