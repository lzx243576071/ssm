package com.soecode.web.mapper;

import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AppraiseInfoMapper extends Mapper<AppraiseInfo> {

    List<Map<String,Object>>  selectAppraiseList();

    List<OrderAppraiseInfoVO> selectByUserId(int userId);

}