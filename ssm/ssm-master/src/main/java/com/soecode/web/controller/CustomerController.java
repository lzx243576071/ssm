package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserDO;
import com.soecode.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/common/getCustomerInformation")
    public Result queryUsers(HttpServletRequest request,UserDO userDO) {
        //userID根据用户登录session获取
        int userId = 0;
        return  customerService.queryByUserId(userId);
    }
}
