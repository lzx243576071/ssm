package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.Area;
import com.soecode.web.entity.ReceiveArea;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    Result queryByUserId(int userId);

    Result changeUserInformation(UserInfo userInfo);

    Result getUserApprise(int userId);

    /**
     * 新增收货地址
     * @param receiveArea
     * @return
     */
    Result addReceiverAddress(ReceiveArea receiveArea);

    /**
     * 选择收货地址
     * @param receiveArea
     * @return
     */
    List chooseReceiverAddress(ReceiveArea receiveArea);


    /**
     * 更新收货地址
     * @param receiveArea
     * @return
     */
    Result updteReceiverAddress(ReceiveArea receiveArea);

    /**
     * 删除收货地址
     * @param receiveArea
     * @return
     */
    int deleteReceiverAddress(ReceiveArea receiveArea);

    /**
     * 区域级联查询
     * @param
     * @return
     */
    List<Area> listArea(String areaCode);
}
