package com.soecode.web.service.impl;

import com.soecode.web.cache.RedisCacheServiceAdapter;
import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserDO;
import com.soecode.web.mapper.SystemInfoMapper;
import com.soecode.web.service.SystemInfoService;
import com.soecode.web.util.CookieUtils;
import com.soecode.web.util.MD5Util;
import com.soecode.web.util.Session.BizCons;
import com.soecode.web.util.Session.UserSession;
import com.soecode.web.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    private SystemInfoMapper systemInfoMapper;
    @Resource
    private RedisCacheServiceAdapter redisCacheServiceAdapter;

    @Override
    public Result<List<SystemInfo>> queryUsers(HttpServletRequest request, HttpServletResponse response, SystemInfo systemInfo) {
        Result result = Result.createFailResult();
        List<SystemInfo> list = systemInfoMapper.queryUser(systemInfo);
        List<SystemInfo> listUserName= new ArrayList<>();
        if(list.size()<0) {
            systemInfo.setSysUserPassword(null);
             listUserName =  systemInfoMapper.queryUser(systemInfo);
            if(listUserName.size()==0) {
                return result.value("用户名不存在");
            }else{
                return result.value("密码错误");
            }
        }
        SystemInfo systemInfo1 = list.get(0);
        Map<String, Object> map = afterLoginProcess(systemInfo1);

        CookieUtils.addCookie(request, response, Constants.WEB_SESSSION_ID_KEY, "" + map.get("sessionId"), BizCons.USER_SESSION_TIMEOUT, BizCons.APP_DOMAIN, "/");
        CookieUtils.addCookie(request, response, Constants.WEB_USER_ID_KEY, "" + map.get("userId"), BizCons.USER_SESSION_TIMEOUT, BizCons.APP_DOMAIN, "/");
        CookieUtils.addCookie(request, response, Constants.WEB_SESSSION_TRACK_KEY, "" + map.get("idstr"), BizCons.USER_SESSION_TIMEOUT * 10, BizCons.APP_DOMAIN, "/");

        return Result.createSuccessResult(list);
    }

    private Map<String, Object> afterLoginProcess(SystemInfo user) {
        redisCacheServiceAdapter.del(Constants.LOGIN_RETRY_PRIFIX + user.getId());

        UserSession<SystemInfo> userSession = new UserSession<>(user, null);
        redisCacheServiceAdapter.set(userSession.getSessionId(), userSession);
        redisCacheServiceAdapter.set("login-" + user.getSysUserMobile(), userSession.getSessionId());


        String idstr = MD5Util.getMD5Code("" + user.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", userSession.getSessionId());
        map.put("userId", user.getId());
        map.put("idstr", idstr);
        map.put("rcUserId", user.getId());

        return map;
    }
}
