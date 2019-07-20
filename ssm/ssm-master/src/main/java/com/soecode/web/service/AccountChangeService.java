package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AccountChange;

public interface AccountChangeService {

    Result recharge(AccountChange accountChange);

    Result<AccountChange> queryAccountRecord(AccountChange accountChange);
}
