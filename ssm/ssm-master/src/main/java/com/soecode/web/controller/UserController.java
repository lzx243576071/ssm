package com.soecode.web.controller;

import com.soecode.web.dto.Result;
import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by luzhexuan on 2019/7/13.
 *用户管理
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "login")
    public Result queryItemClassifyList() {

        return MessageClient.createMessage(userService.queryUsers());
    }
}
