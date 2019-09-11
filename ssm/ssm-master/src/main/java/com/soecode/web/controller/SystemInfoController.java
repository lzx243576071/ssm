package com.soecode.web.controller;

import com.eimageglobal.common.client.domain.model.ModualFunc;
import com.soecode.web.cache.RedisCacheServiceAdapter;
import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.ModuleFunc;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
     * 查询当前用户菜单
     *
     * @return 菜单
     */
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public MessageBean<List<Map<String, Object>>> listMenus(Integer roleId,HttpServletRequest request) {
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        if(roleId == null) {
            return MessageClient.createMessage(dataList);
        }
        List<ModuleFunc> menusList = systemInfoService.selectMenusList(roleId);


        for (ModuleFunc modualfunc : menusList) {
            Map<String, Object> data = new HashMap<String, Object>(6);


////            String parentId = map.get("moduleId").toString();
//            List<Map<String, Object>> childMenusList = systemInfoService.selectChildMenusList(parentId,roleId);
//            menusList.add()
        }
//        for (CasPermissionInfo casPermissionInfo : tModualFuncService.selectByUserId(userId, Long.valueOf(code), "10")) {
//
//            Map<String, Object> data = new HashMap<String, Object>(6);
//            data.put("key", casPermissionInfo.getUrl());
//
//            data.put("name", casPermissionInfo.getName());
//            data.put("icon", casPermissionInfo.getIcon());
//            List<Map<String, Object>> childDataList = new ArrayList<Map<String, Object>>();
//            List<CasPermissionInfo> functionChilds = tModualFuncService.selectByUserId(userId, casPermissionInfo.getId(), "10");
//            if (!functionChilds.isEmpty()) {
//                data.put("key", functionChilds.get(0).getUrl());
//            }
//            for (CasPermissionInfo functionChild : functionChilds) {
//
//                Map<String, Object> childData = new HashMap<String, Object>(6);
//                childData.put("key", functionChild.getUrl());
//                childData.put("name", functionChild.getName());
//                childData.put("icon", functionChild.getIcon());
//                //三级
//                List<Map<String, String>> childDataList1 = new ArrayList<Map<String, String>>();
//                List<CasPermissionInfo> functionChilds1 = tModualFuncService.selectByUserId(CasSecurityUtil.getCasSubject().getCasSecurity().getCasUser().getUserId(), functionChild.getId(), "10");
//                for (CasPermissionInfo functionChild1 : functionChilds1) {
//
//                    Map<String, String> childData1 = new HashMap<String, String>(5);
//                    childData1.put("key", functionChild1.getUrl());
//                    childData1.put("name", functionChild1.getName());
//                    childData1.put("icon", functionChild1.getIcon());
//                    childDataList1.add(childData1);
//                }
//                if (!childDataList1.isEmpty()) {
//                    childData.put("child", childDataList1);
//                }
//                childDataList.add(childData);
//            }
//
////			boolean hasChild = casPermissionInfo.getChild() != null && casPermissionInfo.getChild() > 0 && functionChilds.isEmpty();
////			if (!hasChild) {
////				if (!childDataList.isEmpty()) {
////					data.put("child", childDataList);
////				}
////				dataList.add(data);
////			}
//            if (!childDataList.isEmpty()) {
//                data.put("child", childDataList);
//            }
//            dataList.add(data);
//        }
        return MessageClient.createMessage(dataList);
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
