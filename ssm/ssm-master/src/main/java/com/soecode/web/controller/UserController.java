package com.soecode.web.controller;


import com.soecode.web.dto.Result;
import com.soecode.web.entity.ReceiveArea;
import com.soecode.web.entity.UserDO;
import com.soecode.web.entity.UserInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;
import com.soecode.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/getUserInformation")
    public Result queryUsers(HttpServletRequest request,UserInfo userInfo) {
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.queryByUserId(userId);
    }

    /**
     * 修改用户信息
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/changeUserInformation")
    public Result changeUserInformation(HttpServletRequest request,UserInfo userInfo) {
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.changeUserInformation(userInfo);
    }

    /**
     * 获取用户评价
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/common/getUserApprise")
    public Result getUserApprise(HttpServletRequest request, UserInfo userInfo) {
        //userID根据用户登录session获取
        int userId = 0;
        return  userService.getUserApprise(userId);
    }

    /**
     * 新增收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addressAdministration/addReceiverAddress")
    public Result addReceiverAddress(ReceiveArea receiveArea) {
        if(receiveArea.getUserId()==0||(receiveArea.getUserId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数userId");
        }
        int icode =  userService.addReceiverAddress(receiveArea);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return Result.createFailResult("新建失败");
    }

    /**
     * 选择收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addressAdministration/chooseReceiverAddress")
    public Result chooseReceiverAddress(ReceiveArea receiveArea) {
        if(receiveArea.getUserId()==0||(receiveArea.getUserId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数userId");
        }
        if(receiveArea.getId()==0||(receiveArea.getId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数id");
        }
        List list =  userService.chooseReceiverAddress(receiveArea);
        return Result.createSuccessResult(list);
    }

    /**
     * 更新收货地址
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("addressAdministration/updateReceiverAddress")
    public Result updteReceiverAddress(ReceiveArea receiveArea) {
        if(receiveArea.getId()==0||(receiveArea.getId()+"").isEmpty()){
            return Result.createFailResult("缺少必要参数id");
        }
        int icode =  userService.updteReceiverAddress(receiveArea);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return Result.createFailResult("更新失败");
    }

    /**
     * 区域级联查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/area/list")
    public Result listArea(Long parentId) {
//        if(parentId==0){
//            return Result.createFailResult("缺少必要参数parentId");
//        }
        List list =  userService.listArea(parentId);
        return Result.createSuccessResult(list);
    }

}
