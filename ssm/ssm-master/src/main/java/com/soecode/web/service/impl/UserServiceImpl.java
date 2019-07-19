package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserDO;
import com.soecode.web.mapper.UserMapper;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<List<UserDO>> queryUsers(UserDO userDO) {
     Result result = Result.createFailResult();
        List<UserDO> list = userMapper.queryUser(userDO);
        if(list.size()<0) {
            userDO.setUserPassword(null);
            List<UserDO> listUserName = userMapper.queryUser(userDO);
            if(listUserName.size()==0) {
                return result.value("用户名不存在");
            }else{
                return result.value("密码错误");
            }
        }
        return Result.createSuccessResult(list);
    }
}
