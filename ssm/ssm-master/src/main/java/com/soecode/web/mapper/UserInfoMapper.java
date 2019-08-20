package com.soecode.web.mapper;

import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends Mapper<UserInfo> {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(UserInfo record);
//
//    int insertSelective(UserInfo record);
//
//    UserInfo selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(UserInfo record);
//
//    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> queryUserInfo(UserInfo record);

    Map<String,Object> queryUserInfo_order(Integer userId);
}