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

//	public static void getUserById(Context ctx) throws SQLException, IOException {
//		int id = Integer.parseInt(ctx.pathParam("id"));
//		User u = us.getUserById(id);
//
//		if (u != null) {
//			ctx.json(u);
//			ctx.status(HttpCode.OK);
//		} else {
//			ctx.status(404);
//			ctx.status(HttpCode.NOT_FOUND);
//		}
//
//	}

	public static void submitMyRequest(Context ctx) {
		ctx.result("list");

	}

	public static void viewMyResolved(Context ctx) {
		EmployeeServices es = new EmployeeServices();
		User u = null;
		try {
			int id = Integer.parseInt(SplitTok(ctx)[0]);
			System.out.println(id);
			u = us.getUserById(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
		ArrayList<Reimbursements> ar = es.viewMyResolved(u);
		System.out.println(ar);
		ctx.json(ar);
		ctx.status(HttpCode.CREATED);
}
	

	public static String[] SplitTok(Context ctx) {
		String token = ctx.header("Authorization");
		String[] tok = token.split(":");
		return tok;
	}

	public static void viewMyPending(Context ctx) {
			EmployeeServices es = new EmployeeServices();
			User u = null;
			try {
				int id = Integer.parseInt(SplitTok(ctx)[0]);
				System.out.println(id);
				u = us.getUserById(id);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(u);
			ArrayList<Reimbursements> ar = es.viewMyPending(u);
			System.out.println(ar);
			ctx.json(ar);
			ctx.status(HttpCode.CREATED);
	}

}
