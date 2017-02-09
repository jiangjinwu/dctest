package com.dc.function.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.dc.function.user.model.AccountInfo;

public interface AccountRepository  extends CrudRepository<AccountInfo, Long> {

	AccountInfo getAccountByAccountName(String accountName);
}
