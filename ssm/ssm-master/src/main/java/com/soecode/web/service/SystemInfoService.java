package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.SystemInfo;

import java.util.List;

public interface SystemInfoService {

    Result<List<SystemInfo>> queryUsers(SystemInfo systemInfo);
}
