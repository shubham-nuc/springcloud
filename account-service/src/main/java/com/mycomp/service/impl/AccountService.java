package com.mycomp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.data.dataservice.IDataAccountService;
import com.mycomp.model.AccountDTO;
import com.mycomp.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	
	 @Autowired
	IDataAccountService accountDataService;

	public Optional<AccountDTO> addAccount(AccountDTO accountDTO) {
		return accountDataService.addAccount(accountDTO);
	}

	@Override
	public Optional<AccountDTO> getAccount(int accountNo) {
		return accountDataService.getAccount(accountNo);
	}
}
