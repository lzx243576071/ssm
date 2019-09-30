package com.soecode.web.service.impl;



import com.soecode.web.dto.Result;
import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.mapper.*;
import com.soecode.web.query.weChatQuery;
import com.soecode.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Result queryoneKeyOrderList(weChatQuery query) {
        Map<String,Object> map = new HashMap();
        List<Map<String,Object>> itemClassifyList = itemClassifyMapper.selectItemClassifyList();
        if(query.getUserId()==null||"".equals(query.getUserId())){
            query.setUserId(0);
        }
        List<Map<String,Object>> XSQGItemList = itemInfoMapper.selectXSQGItemList(query);
        List<Map<String,Object>>appraiseList = appraiseInfoMapper.selectAppraiseList();
        map.put("itemClassifyList",itemClassifyList);
        map.put("XSQGItemList",XSQGItemList);
        map.put("appraiseList",appraiseList);
        return Result.createSuccessResult(map);
    }

    @Override
    public Result queryItemList(weChatQuery query) {
        Map<String,Object> map = new HashMap<>();
        if(query.getUserId()==null||"".equals(query.getUserId())){
             query.setUserId(0);
        }
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
        return Result.createSuccessResult(map);
    }

    @Override
    public Result addShopCart(weChatQuery query) {
      if (query.getId()==null||"".equals(query.getId())){//新增
          query.setCreateTime(new Date());
          query.setUpdateTime(new Date());
          shopCartInfoMapper.insert(query);
      }else{//已新增，修改数量
          Map<String,Object> itemNum = shopCartInfoMapper.queryItemNum(query.getId());
          int num = 0;
          if(query.getFlag()==1){
              num = (int) itemNum.get("num")+1;
          }else{
              num = (int) itemNum.get("num")-1;
          }
          shopCartInfoMapper.updateItemNum(query.getId(),num);
      }
     Map<String,Object>map=new HashMap<>();
      map.put("id",query.getId());
    return Result.createSuccessResult(map);
    }


    public Result queryShopCart(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>>ShopCartList =  shopCartInfoMapper.queryShopCart(userId);
//        int numTotal=0;
//        double priceTotal=0;
//        if(ShopCartList.size()!=0){
//            for(int i=0;i<ShopCartList.size();i++){
//             int num= Integer.parseInt(ShopCartList.get(i).get("num").toString());
//             double itemPrice = Double.parseDouble(ShopCartList.get(i).get("itemPrice").toString());
//             numTotal = numTotal+ num;
//             priceTotal = priceTotal + itemPrice*num;
//            }
//        }
        map.put("ShopCartList",ShopCartList);
//        map.put("numTotal",numTotal);
////        map.put("priceTotal",priceTotal);
        return Result.createSuccessResult(map);
    }



    public Result deleteShopCart(String shopId) {
        List<String> id = new ArrayList<>();
        String[] ids = shopId.split(",");
        id = Arrays.asList(ids);
        shopCartInfoMapper.deleteShopCart(id);
        return Result.createSuccessResult();
    }

    public Result queryPrice(String shopId) {
        List<String> id = new ArrayList<>();
        String[] ids = shopId.split(",");
        id = Arrays.asList(ids);
        Map<String,Object>map = new HashMap<>();
        int totalNum = 0;
        double totalPrice = 0.0;
        for(int i=0;i<id.size();i++){
            int id2 = Integer.parseInt(id.get(i));
            Map<String,Object>priceMap= shopCartInfoMapper.queryPrice(id2);
            totalNum = totalNum +  Integer.parseInt(priceMap.get("num").toString());
            totalPrice = totalPrice + Double.parseDouble(priceMap.get("countPrice").toString());
        }
        map.put("totalNum",totalNum);
        map.put("totalPrice",totalPrice);
        return Result.createSuccessResult(map);
    }

    public Result queryDefaultReceiveArea(weChatQuery query) {
        Map<String,Object> map = receiveAreaMapper.queryDefaultReceiveArea(query);
        return Result.createSuccessResult(map);
    }

    public Result submitOrder(OrderInfo queryOI,OrderDetail queryOD,String shopId){
        Result result = Result.createFailResult();
        List<String> id = new ArrayList<>();
        String[] ids = shopId.split(",");
        id = Arrays.asList(ids);
        List<Map<String,Object>>ShopCartList = shopCartInfoMapper.querySubmitItem(id);//查询订单商品信息
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
        queryOI.setStartOrderTime(new Date());
        queryOI.setUserName(UserInfo.get("userName").toString());
        queryOI.setCreateTime(new Date());
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
                queryOD.setCreateTime(new Date());
                orderDetailMapper.insertOrderDetail(queryOD);
                //更新购物车商品状态
                shopCartInfoMapper.updateShopCartState(queryOI.getUserId(),(Integer) ShopCartList.get(i).get("itemId"));
            }
        }
        return result;
    }
}
