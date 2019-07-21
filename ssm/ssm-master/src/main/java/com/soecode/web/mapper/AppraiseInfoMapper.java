package com.soecode.web.mapper;

import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;

import java.util.List;
import java.util.Map;

public interface AppraiseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppraiseInfo record);

    int insertSelective(AppraiseInfo record);

    List<OrderAppraiseInfoVO> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(AppraiseInfo record);

    int updateByPrimaryKey(AppraiseInfo record);

    List<Map<String,Object>> selectAppraiseList();

    List<OrderAppraiseInfoVO> queryAppraiseWithOrder(int UserId);
}