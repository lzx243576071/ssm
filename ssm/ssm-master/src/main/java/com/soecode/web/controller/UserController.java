package com.soecode.web.controller;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserDO;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by luzhexuan on 2019/7/13.
 *用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result queryUsers(UserDO userDO) {
        return  userService.queryUsers(userDO);
    }
}
