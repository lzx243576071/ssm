package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AccountChange;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.mapper.AccountChangeMapper;
import com.soecode.web.mapper.UserInfoMapper;
import com.soecode.web.service.AccountChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountChangeServiceImpl implements AccountChangeService {

    @Autowired
    private AccountChangeMapper accountChangeMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Result recharge(AccountChange accountChange) {
        Result result = Result.createFailResult();
        if(null==accountChange.getUserId() || accountChange.getUserId()==0){
            return result.value("缺少必要参数userId");
        }
        if(null==accountChange.getRechargeMoney() || accountChange.getUserId()<=0){
            return result.value("充值金额大于0");
        }
        UserInfo userinfo = new UserInfo();
        userinfo.setUserId(accountChange.getUserId());
        List<UserInfo>  userInfos = userInfoMapper.queryUserInfo(userinfo);
        if(userInfos.size()==0){
            return result.value("查不到该用户信息");
        }

        Double accountMoney = userInfos.get(0).getUserAccount();
        accountChange.setRestMoney(accountMoney+accountChange.getRechargeMoney()+accountChange.getGivenMoney());
        int icode = accountChangeMapper.insertSelective(accountChange);
        if(icode==0){
            result.value("充值失败");
        }
        userinfo.setUserAccount(accountMoney+accountChange.getRechargeMoney()+accountChange.getGivenMoney());
        int code = userInfoMapper.updateByPrimaryKeySelective(userinfo);
        if(code==0){
//            logger.error("用户修改余额失败,"+"余额应为:"+accountMoney+accountChange.getRechargeMoney());
            return result.value("用户余额修改失败");
        }
        return Result.createSuccessResult("充值成功");
    }

    @Override
    public Result<List<AccountChange>> queryAccountRecord(AccountChange accountChange) {
        List<AccountChange> accountRecordList = accountChangeMapper.selectByPrimaryKey(accountChange.getUserId());
        return Result.createSuccessResult(accountRecordList);
    }
}
