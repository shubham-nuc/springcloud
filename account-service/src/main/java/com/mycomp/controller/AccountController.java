package com.mycomp.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.model.AccountDTO;
import com.mycomp.service.IAccountService;

@RestController
@Path("/account")
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	//http://localhost:8081/app/v1/account/addAccount
	@POST
	@Path("/addAccount")
	public void addAccount(@RequestBody AccountDTO accountDTO) {
		accountService.addAccount(accountDTO);
	}

}
