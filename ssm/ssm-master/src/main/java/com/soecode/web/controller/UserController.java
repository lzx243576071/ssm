package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserDO;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.queryByUserId(userId);
    }

    /**
     * 修改用户信息
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/changeUserInformation")
    public Result changeUserInformation(HttpServletRequest request,UserInfo userInfo) {
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.changeUserInformation(userInfo);
    }


    @RequestMapping(value = "/common/getUserApprise")
    public Result getUserApprise(HttpServletRequest request,UserInfo userInfo) {
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.getUserApprise(userId);
    }

}
