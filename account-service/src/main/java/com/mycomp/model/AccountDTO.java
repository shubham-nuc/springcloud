package com.mycomp.model;

import lombok.Data;

@Data
public class AccountDTO {
	
	private int accountNo;
	private long accountBalance;
	private int userId;
	private String accountType;
	
}
