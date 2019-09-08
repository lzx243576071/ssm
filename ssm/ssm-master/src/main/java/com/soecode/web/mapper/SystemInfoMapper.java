package com.soecode.web.mapper;

import com.soecode.web.entity.ModuleFunc;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.entity.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SystemInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);

    List queryUser(SystemInfo systemInfo);

    List<ModuleFunc> selectMenusList(Integer roleId);

    List<Map<String,Object>> selectChildMenusList(@Param("parentId") String parentId,@Param("roleId") Integer roleId);
}