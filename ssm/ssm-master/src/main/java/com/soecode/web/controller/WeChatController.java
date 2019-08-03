package com.soecode.web.controller;



import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;
import com.soecode.web.query.weChatQuery;
import com.soecode.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
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

    /**
     *  加入购物车
     * @return
     */
    @RequestMapping(value = "addShopCart", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> addShopCart(weChatQuery query) throws ParseException {

        return MessageClient.createMessage(weChatService.addShopCart(query));
    }


    /**
     *  购物车列表
     * @return
     */
    @RequestMapping(value = "queryShopCart", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> queryShopCart(weChatQuery query) {

        return MessageClient.createMessage(weChatService.queryShopCart(query));
    }


}
