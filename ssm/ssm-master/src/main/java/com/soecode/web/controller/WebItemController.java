package com.soecode.web.controller;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.eimageglobal.basis.common.exception.BusinessException;
import com.soecode.web.dto.Result;
import com.soecode.web.dto.UploadFiles;
import com.soecode.web.entity.ItemClassify;
import com.soecode.web.entity.ItemInfo;
import com.soecode.web.message.HeaderCode;
import com.soecode.web.query.ItemInfoQuery;
import com.soecode.web.service.WebItemService;

import com.soecode.web.util.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Created by luzhexuan on 2019/8/18.
 *web接口
 */
@RestController
@RequestMapping("item")
public class WebItemController {

    @Autowired
    private WebItemService webItemService;

    /**
     * 新增项目分类
     * @param itemClassify
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createItemClassify")
    public Result createItemClassify(HttpServletRequest request,ItemClassify itemClassify){
        Result result = Result.createFailResult();
        String path =new UploadFiles().upload2(request);
        if(StringUtils.isNotEmpty(path)) {
            itemClassify.setClassifyImg(path);
        }
        if(StringUtils.isEmpty(itemClassify.getClassifyName())){
            return result.error("请输入对应的项目分类名字");
        }
        return webItemService.createItemClassify(itemClassify);
    }

    /**
     * 修改项目分类
     * @param itemClassify
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateItemClassify")
    public Result updateItemClassify(HttpServletRequest request,ItemClassify itemClassify){
        Result result = Result.createFailResult();
        if(null!=itemClassify.getClassifyId() || itemClassify.getClassifyId()==0){
            result.error("缺少必要参数classifyId");
        }
        String path =new UploadFiles().upload2(request);
        if(StringUtils.isNotEmpty(path)) {
            itemClassify.setClassifyImg(path);
        }
        return webItemService.updateItemClassify(itemClassify);
    }

    /**
     * 删除项目分类
     * @param itemClassify
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteItemClassify")
    public Result deleteItemClassify(HttpServletRequest request,ItemClassify itemClassify){
        Result result = Result.createFailResult();
        if(null!=itemClassify.getClassifyId() || itemClassify.getClassifyId()==0){
            result.error("缺少必要参数classifyId");
        }
        return webItemService.deleteItemClassify(itemClassify);
    }

    /**
     * 新增商品
     * @param dto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addItemInfo" ,method = RequestMethod.POST)
    public Result addItemInfo(ItemInfoQuery dto){
        Result result = Result.createFailResult();
//        if(null!=dto.getItemId() || dto.getItemId()==0){
//            result.error("缺少必要参数itemId");
//        }
        List<MultipartFile> itemImg = dto.getItemImg();
        if (itemImg != null) {
            for (MultipartFile file : itemImg) {
                if (file.getSize() > Constants.MAX_IMAGE_SIZE_REF) {
                    throw new BusinessException(HeaderCode.RespContent.FailShowContent.getCode(), "图片大小不得超过5M");
                }
            }
        }
        return webItemService.addItemInfo(dto);
    }
}
