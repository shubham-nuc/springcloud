package com.mycomp.data.dataservice.impl;

import java.util.Optional;

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
	
	public Optional<AccountDTO> addAccount(AccountDTO accountDTO) {
		AccountEntity accountEntity=accountRepository.save(convertDtoToEntity(accountDTO));
		return Optional.ofNullable(convertEntityToDto(accountEntity));
	}
	
	private AccountEntity convertDtoToEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountNo(accountDTO.getAccountNo());
		accountEntity.setAccountBalance(accountDTO.getAccountBalance());
		accountEntity.setAccountType(accountDTO.getAccountType());
		accountEntity.setUserId(accountDTO.getUserId());
		return accountEntity;
	}
	
	private AccountDTO convertEntityToDto(AccountEntity accountEntity) {
		if(accountEntity!=null) {
		AccountDTO accountDTO=new AccountDTO();
		accountDTO.setAccountNo(accountEntity.getAccountNo());
		accountDTO.setAccountBalance(accountEntity.getAccountBalance());
		accountDTO.setAccountType(accountEntity.getAccountType());
		accountDTO.setUserId(accountEntity.getUserId());
		return accountDTO;
		}
		return null;
	}
}
