package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.ItemClassify;
import com.soecode.web.mapper.ItemClassifyMapper;
import com.soecode.web.service.WebItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebItemServiceImpl implements WebItemService {

    @Autowired
    private ItemClassifyMapper itemClassifyMapper;

    @Override
    public Result createItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setCreateTime(new Date());
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.insertSelective(itemClassify);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result updateItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.updateByPrimaryKeySelective(itemClassify);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result deleteItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.deleteByPrimaryKey(itemClassify.getClassifyId());
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }
}
