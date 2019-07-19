package com.soecode.web.controller;



import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;
import com.soecode.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Jiangyue on 2019/6/29.
 *微信公众号接口
 */

@RestController
@RequestMapping("weChat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;



    /**
     * 一键下单界面
     * @return
     */
    @RequestMapping(value = "oneKeyOrder", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> queryItemClassifyList() {

        return MessageClient.createMessage(weChatService.queryoneKeyOrderList());
    }

}
