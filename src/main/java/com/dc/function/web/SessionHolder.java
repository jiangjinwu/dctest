package com.dc.function.web;

import java.util.Map;

import com.dc.function.user.model.AccountInfo;

public class SessionHolder {

	static Map<Long,AccountInfo> map;
	
	public static AccountInfo getAccount(Long accountId){
		return(AccountInfo)map.get(accountId);
	}
	
	public static AccountInfo setAccount(AccountInfo account){
		return(AccountInfo)map.put(account.getAccountId(),account);
	}
}
