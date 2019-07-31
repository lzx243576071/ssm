package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SystemInfoService {

    Result<List<SystemInfo>> queryUsers(HttpServletRequest request, HttpServletResponse response, SystemInfo systemInfo);
}
