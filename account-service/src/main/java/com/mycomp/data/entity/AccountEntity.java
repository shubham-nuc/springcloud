package com.mycomp.data.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SG_ACCOUNT")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@Column(name = "ACCOUNT_NO")
	private int accountNo;
	
	@Column(name = "ACCOUNT_BALANCE")
	private long accountBalance;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "USER_ID")
	private int userId;
}
