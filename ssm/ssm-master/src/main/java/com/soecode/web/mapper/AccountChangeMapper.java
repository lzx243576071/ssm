package com.soecode.web.mapper;

import com.soecode.web.entity.AccountChange;

public interface AccountChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountChange record);

    int insertSelective(AccountChange record);

    AccountChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountChange record);

    int updateByPrimaryKey(AccountChange record);
}