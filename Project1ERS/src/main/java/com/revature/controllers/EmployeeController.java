package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.services.EmployeeServices;
import com.revature.services.UsersServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {

	private static UsersServices us = new UsersServices();
	private static EmployeeServices es = new EmployeeServices();

	public static void getUserById(Context ctx) throws SQLException, IOException {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = us.getUserById(id);

		if (u != null) {
			ctx.json(u);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(404);
			ctx.status(HttpCode.NOT_FOUND);
		}

	}

	public static void submitMyRequest(Context ctx) {
		ctx.result("list");

	}

	public static void viewMyResolved(Context ctx) {
		if (AuthController.checkToken(ctx) == true) {
			EmployeeServices es = new EmployeeServices();
			User u = new User();
			u.setUsername(SplitTok(ctx)[0]);
			ArrayList<Reimbursements> ar = es.viewMyResolved(u);
			ctx.json(ar);
		} else {
			ctx.result("false");
		}
	}

	public static String[] SplitTok(Context ctx) {
		String token = ctx.header("auth");
		String[] tok = token.split(":");
		return tok;
	}

	public static void viewMyPending(Context ctx) {
		if (AuthController.checkToken(ctx) == true) {
			EmployeeServices es = new EmployeeServices();
			User u = new User();
			u.setUsername(SplitTok(ctx)[0]);
			ArrayList<Reimbursements> ar = es.viewMyPending(u);
			ctx.json(ar);
		} else {
			ctx.result("false");
		}
	}

}
