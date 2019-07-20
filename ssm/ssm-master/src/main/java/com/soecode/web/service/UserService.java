package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    Result queryByUserId(int userId);

    Result changeUserInformation(UserInfo userInfo);

    Result getUserApprise(int userId);
}
