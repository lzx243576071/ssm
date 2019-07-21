package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.*;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;
import com.soecode.web.mapper.*;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private AppraiseInfoMapper appraiseInfoMapper;
    @Autowired
    private ReceiveAreaMapper receiveAreaMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public Result queryByUserId(int userId) {
        Result result = Result.createFailResult();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        List<UserInfo> customerInformation = userInfoMapper.queryUserInfo(userInfo);
        return Result.createSuccessResult(customerInformation);
    }

    @Override
    public Result changeUserInformation(UserInfo userInfo) {
        Result result = Result.createFailResult();
        int icode =  userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(icode>0){
            return Result.createSuccessResult("保存成功");
        }
        return result.value("修改失败");

    }

    @Override
    public Result getUserApprise(int userId) {
        List<OrderAppraiseInfoVO> orderAppraiseInfosList = appraiseInfoMapper.selectByUserId(userId);
        if(orderAppraiseInfosList.size()==0) {
            return Result.createSuccessResult();
        }
            for (OrderAppraiseInfoVO orderAppraiseInfoVO : orderAppraiseInfosList) {
                List<OrderAppraiseInfoVO> orderDetailList = orderDetailMapper.selectMaxNumType(orderAppraiseInfoVO.getOrderId());
                if(orderDetailList.size()==0){
                    return Result.createFailResult("无该订单具体数据");
                }
                orderAppraiseInfoVO.setGoodsType(orderDetailList.get(0).getClassifyName());
                orderAppraiseInfosList.add(orderAppraiseInfoVO);
            }
       return Result.createSuccessResult(orderAppraiseInfosList);
    }

    @Override
    public int addReceiverAddress(ReceiveArea receiveArea) {
        return receiveAreaMapper.insertSelective(receiveArea);
    }

    @Override
    public List<ReceiveArea> chooseReceiverAddress(ReceiveArea receiveArea) {
        return receiveAreaMapper.selectByPrimaryKey(receiveArea.getId());
    }

    @Override
    public int updteReceiverAddress(ReceiveArea receiveArea) {
        return receiveAreaMapper.updateByPrimaryKeySelective(receiveArea);
    }

    @Override
    public List<Area> listArea(Long parentId) {
        Area area = new Area();
        area.setParentId(parentId);
        return areaMapper.listArea(area);
    }

}
