package com.soecode.web.service.impl;



import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.mapper.*;
import com.soecode.web.query.weChatQuery;
import com.soecode.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信接口实现类
 *
 * Created by Jiangyue on 07/02/2017.
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    private ItemClassifyMapper itemClassifyMapper;
    @Autowired
    private ItemInfoMapper itemInfoMapper;
    @Autowired
    private AppraiseInfoMapper appraiseInfoMapper;
    @Autowired
    private ShopCartInfoMapper shopCartInfoMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private ReceiveAreaMapper receiveAreaMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Map<String,Object> queryoneKeyOrderList() {
        Map<String,Object> map = new HashMap();
        List<Map<String,Object>> itemClassifyList = itemClassifyMapper.selectItemClassifyList();
        List<Map<String,Object>> XSQGItemList = itemInfoMapper.selectXSQGItemList();
        List<Map<String,Object>>appraiseList = appraiseInfoMapper.selectAppraiseList();
        map.put("itemClassifyList",itemClassifyList);
        map.put("XSQGItemList",XSQGItemList);
        map.put("appraiseList",appraiseList);
        return map;
    }

    @Override
    public Map<String,Object> queryItemList(weChatQuery query) {
        Map<String,Object> map = new HashMap<>();
        if(query.getItemName()!=""&&query.getItemName()!=null){
            List<Map<String,Object>>goodsList =  itemInfoMapper.queryByItemName(query);
            map.put("goodsList",goodsList);
        }else{
            List<Map<String,Object>>goodsList =  itemInfoMapper.queryByClassifyId(query);
            map.put("全部",goodsList);
            query.setSeason(1);
            List<Map<String,Object>>goodsList1 =  itemInfoMapper.queryByClassifyId(query);
            map.put("春秋",goodsList1);
            query.setSeason(2);
            List<Map<String,Object>>goodsList2 =  itemInfoMapper.queryByClassifyId(query);
            map.put("夏季",goodsList2);
            query.setSeason(3);
            List<Map<String,Object>>goodsList3 =  itemInfoMapper.queryByClassifyId(query);
            map.put("冬季",goodsList3);
            query.setSeason(4);
            List<Map<String,Object>>goodsList4 =  itemInfoMapper.queryByClassifyId(query);
            map.put("其他",goodsList4);
        }
        return map;
    }

    @Override
    public Map<String,Object> addShopCart(weChatQuery query) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(new Date());
        Date nowdate = sf.parse(format);
        Map<String,Object> userInfo = shopCartInfoMapper.queryUserId(query);
        query.setUserId((Integer) userInfo.get("userId"));
        query.setCreateTime(nowdate);
        query.setUpdateTime(nowdate);
        shopCartInfoMapper.insert(query);
        return userInfo;
    }



    public Map<String,Object> queryShopCart(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>>ShopCartList =  shopCartInfoMapper.queryShopCart(userId);
        int numTotal=0;
        double priceTotal=0;
        if(ShopCartList.size()!=0){
            for(int i=0;i<ShopCartList.size();i++){
             int num= Integer.parseInt(ShopCartList.get(i).get("num").toString());
             double itemPrice = Double.parseDouble(ShopCartList.get(i).get("itemPrice").toString());
             numTotal = numTotal+ num;
             priceTotal = priceTotal + itemPrice*num;
            }
        }
        map.put("ShopCartList",ShopCartList);
        map.put("numTotal",numTotal);
        map.put("priceTotal",priceTotal);
        return map;
    }

    public Map<String,Object> queryDefaultReceiveArea(weChatQuery query) {
        Map<String,Object> map = receiveAreaMapper.queryDefaultReceiveArea(query);
        return map;
    }

    public void submitOrder(OrderInfo queryOI,OrderDetail queryOD) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(new Date());
        Date nowdate = sf.parse(format);
        List<Map<String,Object>>ShopCartList = shopCartInfoMapper.queryShopCart(queryOI.getUserId());//查询订单商品信息
        Map<String,Object> UserInfo =  userInfoMapper.queryUserInfo_order(queryOI.getUserId());//查询用户昵称
        int numTotal=0;
        double priceTotal=0;
        if(ShopCartList.size()!=0){
            for(int i=0;i<ShopCartList.size();i++){
                int num= Integer.parseInt(ShopCartList.get(i).get("num").toString());
                double itemPrice = Double.parseDouble(ShopCartList.get(i).get("itemPrice").toString());
                numTotal = numTotal+ num;
                priceTotal = priceTotal + itemPrice*num;

            }
        }
        queryOI.setGoodsNum(numTotal);
        queryOI.setOrderMonery(priceTotal);
        queryOI.setStartOrderTime(nowdate);
        queryOI.setUserName(UserInfo.get("userName").toString());
        queryOI.setCreateTime(nowdate);
        orderInfoMapper.insertOrder(queryOI);
        queryOD.setOrderId(queryOI.getOrderId());
        if(ShopCartList.size()!=0) {
            for (int i = 0; i < ShopCartList.size(); i++) {
                queryOD.setGoodsId((Integer) ShopCartList.get(i).get("itemId"));
                queryOD.setGoodsName(ShopCartList.get(i).get("itemName").toString());
                queryOD.setGoodsPrice((Double) ShopCartList.get(i).get("itemPrice"));
                queryOD.setGoodsNum(Integer.valueOf(ShopCartList.get(i).get("num").toString()));
                queryOD.setTotalPrice((Double) ShopCartList.get(i).get("countPrice"));
                queryOD.setGoodsTexture(ShopCartList.get(i).get("goodsTexture").toString());
                queryOD.setGoodsType(ShopCartList.get(i).get("classifyId").toString());
                queryOD.setCreateTime(nowdate);
                orderDetailMapper.insertOrderDetail(queryOD);
                //更新购物车商品状态
                shopCartInfoMapper.updateShopCartState(queryOI.getUserId(),(Integer) ShopCartList.get(i).get("itemId"));
            }
        }


        return;
    }
}
