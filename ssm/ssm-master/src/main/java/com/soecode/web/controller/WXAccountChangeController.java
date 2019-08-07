package com.soecode.web.controller;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AccountChange;
import com.soecode.web.service.AccountChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountChange")
public class WXAccountChangeController {

    @Autowired
    private AccountChangeService accountChangeService;


    /**
     * 充值
     * add by luzhexuan 2019年7月21日00:12:52
     * @param accountChange
     * @return
     */
    @RequestMapping(value = "/money/recharge")
    public Result recharge(AccountChange accountChange) {
        return  accountChangeService.recharge(accountChange);
    }

    /**
     * 查询充值消费记录
     * add by luzhexuan 2019年7月21日00:14:06
     * @param accountChange
     * @return
     */
    @RequestMapping(value = "/money/record")
    public Result<List<AccountChange>> queryAccountRecord(AccountChange accountChange) {
        if(null==accountChange.getUserId()){
            return Result.createFailResult("缺少必要参数userId");
        }
        return  accountChangeService.queryAccountRecord(accountChange);
    }
}
