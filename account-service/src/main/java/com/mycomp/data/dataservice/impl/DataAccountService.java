package com.mycomp.data.dataservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.data.dataservice.IDataAccountService;
import com.mycomp.data.entity.AccountEntity;
import com.mycomp.data.repository.AccountRepository;
import com.mycomp.model.AccountDTO;

@Service
public class DataAccountService implements IDataAccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void addAccount(AccountDTO accountDTO) {
		accountRepository.save(convertToEntity(accountDTO));
	}
	
	private AccountEntity convertToEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountNo(accountDTO.getAccountNo());
		accountEntity.setAccountBalance(accountDTO.getAccountBalance());
		accountEntity.setAccountType(accountDTO.getAccountType());
		accountEntity.setUserId(accountDTO.getUserId());
		return accountEntity;
	}
}
