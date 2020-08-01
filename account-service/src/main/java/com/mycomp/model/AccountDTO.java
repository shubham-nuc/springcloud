package com.mycomp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	
	private int accountNo;
	private long accountBalance;
	private long userId;
	private String accountType;
	
}
