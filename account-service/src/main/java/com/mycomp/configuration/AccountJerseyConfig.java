package com.mycomp.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mycomp.controller.AccountController;

@Component
@ApplicationPath("/app/v1")
public class AccountJerseyConfig extends ResourceConfig {

	
	public AccountJerseyConfig(){
		//register all the Endpoint here 
		register(AccountController.class);
	}
}
