package com.mycomp.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.data.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	AccountEntity findByAccountNo(int accountNo);

}
