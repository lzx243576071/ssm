package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AppraiseInfo;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.mapper.AppraiseInfoMapper;
import com.soecode.web.mapper.UserInfoMapper;
import com.soecode.web.service.UserService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    AppraiseInfoMapper appraiseInfoMapper;


    @Override
    public Result queryByUserId(int userId) {
        Result result = Result.createFailResult();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        List<UserInfo> customerInformation = userInfoMapper.queryUserInfo(userInfo);
        return Result.createSuccessResult(customerInformation);
    }

    @Override
    public Result changeUserInformation(UserInfo userInfo) {
        Result result = Result.createFailResult();
        int icode =  userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(icode>0){
            return Result.createSuccessResult("保存成功");
        }
        return result.value("修改失败");

    }

    @Override
    public Result getUserApprise(int userId) {
        AppraiseInfo appraiseInfos = appraiseInfoMapper.selectByPrimaryKey(userId);
        return Result.createSuccessResult(appraiseInfos);
    }
}
