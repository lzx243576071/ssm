package com.soecode.web.mapper;

import com.soecode.web.entity.UserDO;

import java.util.List;

public interface UserMapper {

    List queryUser(UserDO userDO);
}
