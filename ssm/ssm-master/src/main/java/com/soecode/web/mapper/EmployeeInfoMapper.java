package com.soecode.web.mapper;

import com.soecode.web.entity.EmployeeInfo;

public interface EmployeeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);

    EmployeeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeInfo record);

    int updateByPrimaryKey(EmployeeInfo record);
}