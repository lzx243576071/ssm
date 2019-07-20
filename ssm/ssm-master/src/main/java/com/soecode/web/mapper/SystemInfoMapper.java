package com.soecode.web.mapper;

import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserDO;

import java.util.List;

public interface SystemInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);

    List queryUser(SystemInfo systemInfo);
}