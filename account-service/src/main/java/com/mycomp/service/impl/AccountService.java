package com.mycomp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.data.dataservice.IDataAccountService;
import com.mycomp.model.AccountDTO;
import com.mycomp.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	
	 @Autowired
	IDataAccountService accountDataService;

	public void addAccount(AccountDTO accountDTO) {
		accountDataService.addAccount(accountDTO);
	}
}