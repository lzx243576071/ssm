package com.soecode.web.service.impl;

import com.soecode.web.dto.Result;
import com.soecode.web.mapper.CustomerMapper;
import com.soecode.web.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerMapper customerMapper;


    @Override
    public Result queryByUserId(int userId) {
        Result result = Result.createFailResult();
        List customerInformation = customerMapper.queryByUserId(userId);
        return Result.createSuccessResult(customerInformation);
    }
}
