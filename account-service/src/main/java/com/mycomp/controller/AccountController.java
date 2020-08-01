package com.mycomp.controller;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.model.AccountDTO;
import com.mycomp.service.IAccountService;

@RestController
@Path("/accountApi")
public class AccountController {
	
	@Autowired
	IAccountService accountService;
	
	
	@POST
	@Path("/addAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
		Optional<AccountDTO> accountResp=accountService.addAccount(accountDTO);
		return accountResp.get();
	}
	
	@GET
	@Path("/account/{accountNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountDTO getAccount(@PathParam(value = "accountNo") int accountNo) {
		Optional<AccountDTO> accountResp=accountService.getAccount(accountNo);
		return accountResp.get();
	}

}
