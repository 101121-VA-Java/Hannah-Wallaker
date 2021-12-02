package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.services.AuthServices;
import com.revature.services.EmployeeServices;
import com.revature.services.UsersServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UsersController {

	public static void updateMyInfo(Context ctx) {
		if (AuthController.checkToken(ctx) == true) {
			User u = ctx.bodyAsClass(User.class);
			UsersServices us = new UsersServices();

			if (us.updateMyInfo(u)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		}

	}

	public static void viewMyInfo(Context ctx) throws SQLException, IOException {
		if (AuthController.checkToken(ctx) == true) {
			UsersServices us = new UsersServices();
			User u = us.viewMyInfo(SplitTok(ctx)[0]);
			ctx.json(u);
		} else {
			ctx.result("false");
		}

	}

	public static String[] SplitTok(Context ctx) {
		String token = ctx.header("auth");    	
    	String[] tok = token.split(":");
    	return tok;
	}
}
