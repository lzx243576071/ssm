package com.soecode.web.service;

import com.soecode.web.dto.Result;

import java.util.List;

public interface CustomerService {

    Result queryByUserId(int userId);
}
