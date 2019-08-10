package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.ReceiveArea;
import com.soecode.web.entity.UserDO;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/getUserInformation")
    public Result queryUsers(HttpServletRequest request,UserInfo userInfo) {
        return  userService.queryByUserId(userInfo.getUserId());
    }

    /**
     * 修改用户信息
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/changeUserInformation")
    public Result changeUserInformation(HttpServletRequest request,UserInfo userInfo) {
        return  userService.changeUserInformation(userInfo);
    }

    /**
     * 获取用户评价
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/getUserApprise")
    public Result getUserApprise(HttpServletRequest request, UserInfo userInfo) {
        return  userService.getUserApprise(userInfo.getUserId());
    }

    /**
     * 新增收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addressAdministration/addReceiverAddress")
    public Result addReceiverAddress(HttpServletRequest request,ReceiveArea receiveArea) {
        Result result = Result.createFailResult();
        if(receiveArea.getUserId()<=0L || null==receiveArea.getUserId()){
            result.error(ResultCodeEnums.NOT_LOGIN);
        }
        return userService.addReceiverAddress(receiveArea);
    }

    /**
     * 选择收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addressAdministration/chooseReceiverAddress")
    public Result chooseReceiverAddress(HttpServletRequest request,ReceiveArea receiveArea) {
        Result result = Result.createFailResult();
        //获取userId
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        int userId = 0;
//        Boolean cookieBoolean = false;
//        for (Cookie cookie : cookies) {
//            if(session.getId()==cookie.getValue()){
//                cookieBoolean=true;
//            }
//        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("uid")){
                userId = Integer.parseInt(cookie.getValue());
            }
        }
//        if(session.getAttribute(Constants.WEB_SESSSION_ID_KEY) == null){
//            return result.error(ResultCodeEnums.NOT_LOGIN);
//        }
//        int userId = (Integer) session.getAttribute(Constants.WEB_SESSSION_ID_KEY);
        if(userId == 0){
            result.error(ResultCodeEnums.NOT_LOGIN);
            return result;
        }
        receiveArea.setUserId(userId);
        List list =  userService.chooseReceiverAddress(receiveArea);
        return Result.createSuccessResult(list);
    }

    /**
     * 更新收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("addressAdministration/updateReceiverAddress")
    public Result updateReceiverAddress(HttpServletRequest request,ReceiveArea receiveArea) {
        Result result = Result.createFailResult();
        if(receiveArea.getId()==0||(receiveArea.getId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数id");
        }
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        int userId = 0;
//        Boolean cookieBoolean = false;
//        for (Cookie cookie : cookies) {
//            if(session.getId()==cookie.getValue()){
//                cookieBoolean=true;
//            }
//        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("uid")){
                userId = Integer.parseInt(cookie.getValue());
            }
        }
//        if(session.getAttribute(Constants.WEB_SESSSION_ID_KEY) == null){
//            return result.error(ResultCodeEnums.NOT_LOGIN);
//        }
//        int userId = (Integer) session.getAttribute(Constants.WEB_SESSSION_ID_KEY);
        if(userId == 0){
            result.error(ResultCodeEnums.NOT_LOGIN);
            return result;
        }
        receiveArea.setUserId(userId);
        return userService.updteReceiverAddress(receiveArea);
    }

    /**
     * 删除收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("addressAdministration/deleteReceiverAddress")
    public Result deleterReceiverAddress(ReceiveArea ReceiveArea) {
        if(ReceiveArea.getId()==0||(ReceiveArea.getId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数receiveInfoId");
        }
        int icode =  userService.deleteReceiverAddress(ReceiveArea);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return Result.createFailResult("删除失败");
    }

    /**
     * 区域级联查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/area/list")
    public Result listArea(Long parentId) {
//        if(parentId==0){
//            return Result.createFailResult("缺少必要参数parentId");
//        }
        List list =  userService.listArea(parentId);
        return Result.createSuccessResult(list);
    }

}
