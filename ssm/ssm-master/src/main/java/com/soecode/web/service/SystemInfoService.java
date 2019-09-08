package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.ModuleFunc;
import com.soecode.web.entity.SystemInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface SystemInfoService {

    Result<List<SystemInfo>> queryUsers(HttpServletRequest request, HttpServletResponse response, SystemInfo systemInfo);

    Result addSystemInfo(SystemInfo systemInfo);

    Result updateSystemInfo(SystemInfo systemInfo);

    Result deleteSystemInfo(SystemInfo systemInfo);

    Result getSystemInfoList(SystemInfo systemInfo);

    List<ModuleFunc> selectMenusList(Integer roleId);

    List<Map<String,Object>> selectChildMenusList(String parentId,Integer roleId);
}
