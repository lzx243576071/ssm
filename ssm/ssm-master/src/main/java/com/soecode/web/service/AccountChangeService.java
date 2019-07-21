package com.soecode.web.service;

import com.soecode.web.dto.Result;
import com.soecode.web.entity.AccountChange;

import java.util.List;

public interface AccountChangeService {

    Result recharge(AccountChange accountChange);

    Result<List<AccountChange>> queryAccountRecord(AccountChange accountChange);
}
