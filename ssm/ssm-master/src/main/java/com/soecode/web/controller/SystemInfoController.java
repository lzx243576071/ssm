package com.soecode.web.controller;

import com.soecode.web.cache.RedisCacheServiceAdapter;
import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.service.SystemInfoService;
import com.soecode.web.util.CookieUtils;
import com.soecode.web.util.Session.BizCons;
import com.soecode.web.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by luzhexuan on 2019/7/13.
 *用户管理
 */
@RestController
@RequestMapping("/systemInfo")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @Resource
    private RedisCacheServiceAdapter redisCacheServiceAdapter;

    /**
     * 用户登录
     * @param request
     * @param response
     * @param systemInfo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result queryUsers(HttpServletRequest request, HttpServletResponse response, SystemInfo systemInfo) {
        return  systemInfoService.queryUsers(request,response,systemInfo);
    }


    /**
     * 添加用户
     * @param systemInfo
     * @return
     */
    @RequestMapping(value = "/addSystemInfo", method = RequestMethod.GET)
    public Result addSystemInfo(SystemInfo systemInfo) {
        Result result = Result.createFailResult();
        if(null==systemInfo.getSysUserName()){
            result.error("请输入用户名");
        }
        if(null!=systemInfo.getRoleId()){
            result.error("请给用户分配权限");
        }
        return  systemInfoService.addSystemInfo(systemInfo);
    }

    /**
     * 修改用户
     * @param systemInfo
     * @return
     */
    @RequestMapping(value = "/updateSystemInfo", method = RequestMethod.GET)
    public Result updateSystemInfo(SystemInfo systemInfo) {
        return  systemInfoService.updateSystemInfo(systemInfo);
    }

    /**
     * 删除用户
     * @param systemInfo
     * @return
     */
    @RequestMapping(value = "/deleteSystemInfo", method = RequestMethod.GET)
    public Result deleteSystemInfo(SystemInfo systemInfo) {
        if(null==systemInfo.getSysId()||systemInfo.getSysId()==0){
            return Result.createFailResult().error("缺少必要参数sysId");
        }
        return  systemInfoService.deleteSystemInfo(systemInfo);
    }

    /**
     * 获取用户列表
     * @param systemInfo
     * @return
     */
    @RequestMapping(value = "/getSystemInfoList", method = RequestMethod.GET)
    public Result getSystemInfoList(HttpServletRequest request,SystemInfo systemInfo) {
//        Result result = Result.createFailResult();
//        HttpSession session = request.getSession();
//        if (session.getAttribute(Constants.WEB_USER_ID_KEY) == null) {
//            result.error(ResultCodeEnums.NOT_LOGIN);
//            return result;
//        }
//        int ytUserId = (Integer) session.getAttribute(Constants.WEB_USER_ID_KEY);

        return  systemInfoService.getSystemInfoList(systemInfo);
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout")
    public Result<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.getCookie(request, Constants.WEB_SESSSION_ID_KEY);

        if (cookie != null) {
            CookieUtils.cancleCookie(request, response, Constants.WEB_SESSSION_ID_KEY, BizCons.APP_DOMAIN);
            CookieUtils.cancleCookie(request, response, Constants.WEB_USER_ID_KEY, BizCons.APP_DOMAIN);

            CookieUtils.addCookie(request, response, Constants.WEB_SESSSION_ID_KEY, null, 0, BizCons.APP_DOMAIN, "/");
            CookieUtils.addCookie(request, response, Constants.WEB_USER_ID_KEY, null, 0, BizCons.APP_DOMAIN, "/");
            CookieUtils.addCookie(request, response, Constants.WEB_SESSSION_TRACK_KEY, null, 0, BizCons.APP_DOMAIN, "/");


            redisCacheServiceAdapter.del(cookie.getValue());
        }

        Result<String> result = Result.createSuccessResult();
        return result;
    }
}
