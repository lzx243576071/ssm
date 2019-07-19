package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserDO;

import java.util.List;

public interface UserService {

    Result<List<UserDO>> queryUsers(UserDO userDO);
}
