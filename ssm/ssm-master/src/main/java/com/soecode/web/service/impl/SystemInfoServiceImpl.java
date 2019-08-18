package com.soecode.web.service.impl;

import com.soecode.web.cache.RedisCacheServiceAdapter;
import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;
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

        request.getSession().setAttribute(Constants.WEB_USER_ID_KEY, systemInfo1.getSysId());
        request.getSession().setAttribute(Constants.WEB_SESSSION_ID_KEY, request.getSession().getId());

        return Result.createSuccessResult(list);
    }

    /**
     * 添加用户
     * @param systemInfo
     * @return
     */
    @Override
    public Result addSystemInfo(SystemInfo systemInfo) {
        Result result = Result.createFailResult();
        int icode = systemInfoMapper.insertSelective(systemInfo);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }


    /**
     * 修改用户
     * @param systemInfo
     * @return
     */
    @Override
    public Result updateSystemInfo(SystemInfo systemInfo) {
        Result result = Result.createFailResult();
        int icode = systemInfoMapper.updateByPrimaryKeySelective(systemInfo);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result deleteSystemInfo(SystemInfo systemInfo) {
        Result result = Result.createFailResult();
        int icode = systemInfoMapper.deleteByPrimaryKey(systemInfo.getSysId());
        if(icode>=0){
            return  Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result getSystemInfoList(SystemInfo systemInfo) {
        List<SystemInfo> systemInfoList = systemInfoMapper.queryUser(systemInfo);
        return Result.createSuccessResult(systemInfoList);
    }


    private Map<String, Object> afterLoginProcess(SystemInfo user) {
        redisCacheServiceAdapter.del(Constants.LOGIN_RETRY_PRIFIX + user.getSysId());

        UserSession<SystemInfo> userSession = new UserSession<>(user, null);
        redisCacheServiceAdapter.set(userSession.getSessionId(), userSession);
        redisCacheServiceAdapter.set("login-" + user.getSysUserMobile(), userSession.getSessionId());


        String idstr = MD5Util.getMD5Code("" + user.getSysId());

        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", userSession.getSessionId());
        map.put("userId", user.getSysId());
        map.put("idstr", idstr);
        map.put("rcUserId", user.getSysId());

        return map;
    }
}
