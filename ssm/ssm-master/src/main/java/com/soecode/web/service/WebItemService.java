package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.ItemClassify;

public interface WebItemService {

    Result createItemClassify(ItemClassify itemClassify);

    Result updateItemClassify(ItemClassify itemClassify);

    Result deleteItemClassify(ItemClassify itemClassify);

}
