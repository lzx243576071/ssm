package com.soecode.web.service;

import com.soecode.web.query.LoginQuery;

import java.util.Map;

/**
 * Created by Jiangyue on 2019/7/28.
 */
public interface WXLoginService  {

    void SaveUserInfo(LoginQuery query);

    Map<String,Object> queryUserInfo(LoginQuery query);

    void updateUserInfo(LoginQuery query);
}
