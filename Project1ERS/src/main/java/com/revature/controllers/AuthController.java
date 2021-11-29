package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.services.AuthServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthController {
	
	private static AuthServices as = new AuthServices();
	
    public static void loginSystem(Context ctx) throws SQLException, IOException {   
    		String username = ctx.formParam("username");
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
    




