package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserDO;
import com.soecode.web.mapper.SystemInfoMapper;
import com.soecode.web.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    private SystemInfoMapper systemInfoMapper;

    @Override
    public Result<List<SystemInfo>> queryUsers(SystemInfo systemInfo) {
     Result result = Result.createFailResult();
        List<SystemInfo> list = systemInfoMapper.queryUser(systemInfo);
        if(list.size()<0) {
            systemInfo.setSysUserPassword(null);
            List<SystemInfo> listUserName = systemInfoMapper.queryUser(systemInfo);
            if(listUserName.size()==0) {
                return result.value("用户名不存在");
            }else{
                return result.value("密码错误");
            }
        }
        return Result.createSuccessResult(list);
    }
}
