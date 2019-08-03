package com.soecode.web.service.impl;



import com.soecode.web.entity.ShopCartInfo;
import com.soecode.web.mapper.AppraiseInfoMapper;
import com.soecode.web.mapper.ItemClassifyMapper;
import com.soecode.web.mapper.ItemInfoMapper;
import com.soecode.web.mapper.ShopCartInfoMapper;
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



    public Map<String,Object> queryShopCart(weChatQuery query) {
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>>ShopCartList =  shopCartInfoMapper.queryShopCart(query);
        map.put("ShopCartList",ShopCartList);
        return map;
    }
}
