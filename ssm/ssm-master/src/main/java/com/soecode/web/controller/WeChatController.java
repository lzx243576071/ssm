package com.soecode.web.controller;



import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;
import com.soecode.web.query.weChatQuery;
import com.soecode.web.service.WeChatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Result queryItemClassifyList(weChatQuery query) {

        return weChatService.queryoneKeyOrderList(query);
    }


    /**
     *  商品列表
     * @return
     */
    @RequestMapping(value = "queryItemList", method = RequestMethod.GET)
    public Result queryGoodsList(weChatQuery query) {
        return weChatService.queryItemList(query);
    }



    /**
     *  加入购物车（数量修改）
     * @return
     */
    @RequestMapping(value = "addShopCart", method = RequestMethod.GET)
    public Result addShopCart(weChatQuery query){

        return weChatService.addShopCart(query);
    }

    /**
     *  购物车列表
     * @return
     */
    @RequestMapping(value = "queryShopCart", method = RequestMethod.GET)
    public Result queryShopCart(Integer userId) {
        Result result = Result.createFailResult();
        if(userId ==null){
            return  result.error("缺少必要参数userId");
        }
        return weChatService.queryShopCart(userId);
    }



    /**
     *  查询购物车选中商品数量和总价
     * @return
     */
    @RequestMapping(value = "queryPrice", method = RequestMethod.GET)
    public Result queryPrice(String shopId) {
        Result result = Result.createFailResult();
        if(shopId == null){
            return  result.error("缺少必要参数shopId");
        }
        return weChatService.queryPrice(shopId);
    }

    /**
     *  删除购物车
     * @return
     */
    @RequestMapping(value = "deleteShopCart", method = RequestMethod.GET)
    public Result deleteShopCart(String shopId) {
        Result result = Result.createFailResult();
        if(shopId == null){
            return  result.error("缺少必要参数shopId");
        }
        return weChatService.deleteShopCart(shopId);
    }


    /**
     * 下单界面（默认收货地址）
     */
    @RequestMapping(value = "queryDefaultReceiveArea", method = RequestMethod.GET)
    public Result queryDefaultReceiveArea(weChatQuery query) {

        return weChatService.queryDefaultReceiveArea(query);
    }

    /**
     *  提交订单
     * @return
     */
    @RequestMapping(value = "submitOrder", method = RequestMethod.GET)
    public Result submitOrder(OrderInfo queryOI,OrderDetail queryOD,String shopId){

        return  weChatService.submitOrder(queryOI,queryOD,shopId);
    }

}
