package com.mycomp.service;

import java.util.Optional;

import com.mycomp.model.AccountDTO;

public interface IAccountService {
	
	public Optional<AccountDTO> addAccount(AccountDTO accountDTO);

}
