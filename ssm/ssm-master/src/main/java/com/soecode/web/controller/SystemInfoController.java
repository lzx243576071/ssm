package com.soecode.web.controller;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserDO;
import com.soecode.web.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by luzhexuan on 2019/7/13.
 *用户管理
 */
@RestController
@RequestMapping("/systemInfo")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result queryUsers(SystemInfo systemInfo) {
        return  systemInfoService.queryUsers(systemInfo);
    }
}