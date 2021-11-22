package com.revature.controllers;

import com.revature.services.AuthServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthController {
	
	private static AuthServices as = new AuthServices();
	
	public static void loginSystem(Context ctx) {
		String username = ctx.formParam("uname");
		String password = ctx.formParam("password");
		
		String token = null;
		
		if(username != null && password != null) {
			token = as.loginSystem(username, password);
		}
		
		if(token != null) {
			ctx.header("Authorization", token);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}

}
