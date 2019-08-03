package com.soecode.web.service.impl;

import com.soecode.web.mapper.WXLoginMapper;
import com.soecode.web.query.LoginQuery;
import com.soecode.web.service.WXLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Jiangyue on 2019/7/28.
 */
@Service
public class WXLoginServiceImpl implements WXLoginService {
    @Autowired
    private WXLoginMapper wXLoginMapper;

    public void SaveUserInfo(LoginQuery query) {
        wXLoginMapper.insert(query);
        return;
    }

    public Map<String,Object> queryUserInfo(LoginQuery query) {
        return wXLoginMapper.queryUserInfo(query);
    }

    public void updateUserInfo(LoginQuery query) {
        wXLoginMapper.updateByPrimaryKeySelective(query);
        return;
    }
}
