package com.soecode.web.controller;



import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
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
     *  商品列表
     * @return
     */
    @RequestMapping(value = "queryItemList", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> queryGoodsList(weChatQuery query) {

        return MessageClient.createMessage(weChatService.queryItemList(query));
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
    public MessageBean<Map<String, Object>> queryShopCart(Integer userId) {

        return MessageClient.createMessage(weChatService.queryShopCart(userId));
    }



    /**
     * 下单界面（默认收货地址）
     */
    @RequestMapping(value = "queryDefaultReceiveArea", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> queryDefaultReceiveArea(weChatQuery query) {

        return MessageClient.createMessage(weChatService.queryDefaultReceiveArea(query));
    }

    /**
     *  提交订单
     * @return
     */
    @RequestMapping(value = "submitOrder", method = RequestMethod.GET)
    public MessageBean<Map<String, Object>> submitOrder(OrderInfo queryOI,OrderDetail queryOD) throws ParseException {
        weChatService.submitOrder(queryOI,queryOD);
        return MessageClient.createMessage();
    }

}
