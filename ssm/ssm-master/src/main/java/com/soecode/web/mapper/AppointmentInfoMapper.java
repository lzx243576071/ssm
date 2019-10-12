package com.soecode.web.mapper;

import com.soecode.web.entity.AppointmentInfo;
import com.soecode.web.query.weChatQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppointmentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppointmentInfo record);

    int insertSelective(AppointmentInfo record);

    AppointmentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppointmentInfo record);

    int updateByPrimaryKey(AppointmentInfo record);

    List<Map<String, Object>> queryAppointmentTime(String appointmentDate);

    List<Map<String, Object>> queryAppointmentDate(@Param("appointmentDateStart") String appointmentDateStart, @Param("appointmentDateEnd") String appointmentDateEnd);

    Map<String, Object> queryOrderNumNow(weChatQuery query);

    Map<String, Object> queryIntervalTime(Integer orderId);
}