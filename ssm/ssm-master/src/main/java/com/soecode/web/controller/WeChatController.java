package com.soecode.web.controller;



import com.soecode.web.dto.Result;
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
    public Result queryItemClassifyList() {

        return weChatService.queryoneKeyOrderList();
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
     *  加入购物车
     * @return
     */
    @RequestMapping(value = "addShopCart", method = RequestMethod.GET)
    public Result addShopCart(weChatQuery query) throws ParseException {

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
     *  修改购物车商品数量
     * @return
     */
    @RequestMapping(value = "updateShopCart", method = RequestMethod.GET)
    public Result updateShopCart(Integer id,Integer flag) {
        Result result = Result.createFailResult();
        if(id ==null){
            return  result.error("缺少必要参数id");
        }
        if(flag ==null){
            return  result.error("缺少必要参数flag");
        }
        return weChatService.updateShopCart(id,flag);
    }

    /**
     *  删除购物车
     * @return
     */
    @RequestMapping(value = "deleteShopCart", method = RequestMethod.GET)
    public Result updateShopCart(List<String> id) {
        Result result = Result.createFailResult();
        if(id.size() == 0){
            return  result.error("缺少必要参数id");
        }
        return weChatService.deleteShopCart(id);
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
    public Result submitOrder(OrderInfo queryOI,OrderDetail queryOD){

        return  weChatService.submitOrder(queryOI,queryOD);
    }

}
