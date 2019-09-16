package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.ItemClassify;
import com.soecode.web.entity.ItemInfo;
import com.soecode.web.query.ItemInfoQuery;

public interface WebItemService {

    Result createItemClassify(ItemClassify itemClassify);

    Result updateItemClassify(ItemClassify itemClassify);

    Result deleteItemClassify(ItemClassify itemClassify);

    Result addItemInfo(ItemInfoQuery dto);
}
