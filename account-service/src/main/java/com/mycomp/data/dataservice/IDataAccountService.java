package com.mycomp.data.dataservice;

import java.util.Optional;

import com.mycomp.data.entity.AccountEntity;
import com.mycomp.model.AccountDTO;

public interface IDataAccountService {

	public Optional<AccountDTO> addAccount(AccountDTO accountDTO);

	public Optional<AccountDTO> getAccount(int accountNo);
}
