package com.soecode.web.mapper;

import com.soecode.web.entity.UserInfo;
import com.soecode.web.query.LoginQuery;

/**
 * Created by Jiangyue on 2019/7/28.
 */
public interface WXLoginMapper {
    int insert(LoginQuery query);
}
