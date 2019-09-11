package com.soecode.web.service.impl;

import com.eimageglobal.basis.common.exception.BusinessException;
import com.soecode.web.dto.Result;
import com.soecode.web.entity.ItemClassify;
import com.soecode.web.entity.ItemInfo;
import com.soecode.web.mapper.ItemClassifyMapper;
import com.soecode.web.mapper.ItemInfoMapper;
import com.soecode.web.message.HeaderCode;
import com.soecode.web.query.ItemInfoQuery;
import com.soecode.web.service.WebItemService;
import com.soecode.web.util.FilePathEnum;
import com.soecode.web.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.alipay.util.AlipaySubmit.logger;

@Service
public class WebItemServiceImpl implements WebItemService {

    @Autowired
    private ItemClassifyMapper itemClassifyMapper;
    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Override
    public Result createItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setCreateTime(new Date());
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.insertSelective(itemClassify);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result updateItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.updateByPrimaryKeySelective(itemClassify);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    @Override
    public Result deleteItemClassify(ItemClassify itemClassify) {
        Result result = Result.createFailResult();
        itemClassify.setUpdateTime(new Date());
        int icode = itemClassifyMapper.deleteByPrimaryKey(itemClassify.getClassifyId());
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }


    @Override
    public Result addItemInfo(ItemInfoQuery dto) {
        Result result = Result.createFailResult();
        ItemInfo itemInfo = getItemInfo(dto);
        saveItemImg(dto,itemInfo);//图片上传
        int icode = itemInfoMapper.insert(itemInfo);
        if(icode>0){
            return Result.createSuccessResult();
        }
        return result;
    }

    /**
     * 处理上传的图片
     * @param dto
     * @param itemInfo
     */
    private void saveItemImg(ItemInfoQuery dto, ItemInfo itemInfo) {
        String oldItemImg = dto.getOldItemImg();
        StringBuilder s = new StringBuilder();
        if (oldItemImg != null) {
//            for (String img : oldItemImg,) {
            s.append(oldItemImg);
//            }
        }
        List<MultipartFile> images = dto.getItemImg();
        if (!CollectionUtils.isEmpty(images)) {
            String imgUrl;
            String classifyId = dto.getClassifyId().toString();
            try {
                for (MultipartFile img : images) {
                    imgUrl = FileUtils.uploadFile(img, FilePathEnum.ITEMIMG.getPath(), classifyId);
                    s.append(imgUrl);
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new BusinessException(HeaderCode.RespContent.FailShowContent.getCode(), "上传图片失败");
            }
        }
        if (s.length() > 0) {
            String itemImg = s.toString();
            itemInfo.setItemImg(itemImg);
        }
    }

    private ItemInfo getItemInfo(ItemInfoQuery dto) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setItemName(dto.getItemName());
        itemInfo.setClassifyId(dto.getClassifyId());
        itemInfo.setClassifyName(dto.getClassifyName());
        itemInfo.setItemPrice(dto.getItemPrice());
        itemInfo.setGoodsTexture(dto.getGoodsTexture());
        itemInfo.setSeason(dto.getSeason());
        itemInfo.setWashMethod(dto.getWashMethod());
        itemInfo.setJoinActivities(dto.getJoinActivities());
        itemInfo.setCreateTime(new Date());
        itemInfo.setUpdateTime(new Date());
        return itemInfo;
    }
}
