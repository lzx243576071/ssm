package com.soecode.web.service.impl;



import com.soecode.web.mapper.AppraiseInfoMapper;
import com.soecode.web.mapper.ItemClassifyMapper;
import com.soecode.web.mapper.ItemInfoMapper;
import com.soecode.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String,Object> queryoneKeyOrderList() {
        Map<String,Object> map = new HashMap();
        List<Map<String,Object>> itemClassifyList = itemClassifyMapper.selectItemClassifyList();
        List<Map<String,Object>> XSQGItemList = itemInfoMapper.selectItemClassifyList();
        List<Map<String,Object>>appraiseList = appraiseInfoMapper.selectAppraiseList();
        map.put("itemClassifyList",itemClassifyList);
        map.put("XSQGItemList",XSQGItemList);
        map.put("appraiseList",appraiseList);
        return map;
    }

}
