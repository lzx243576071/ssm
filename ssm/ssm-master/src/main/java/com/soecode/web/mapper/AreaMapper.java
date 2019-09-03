package com.soecode.web.mapper;

import com.soecode.web.entity.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {
    List<Area> listArea(Area area);
}