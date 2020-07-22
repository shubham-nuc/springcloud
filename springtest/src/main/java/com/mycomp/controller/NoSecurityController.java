package com.mycomp.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/noSecApi")
public class NoSecurityController {
	
	@GET
	@Path("/getMsg")
	public String sayHi() {
		return "I am not Secured";
	}
}
