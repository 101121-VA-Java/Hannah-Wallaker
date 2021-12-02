package com.revature.controllers;

import com.revature.models.Reimbursements;
import com.revature.services.ManagerServices;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ManagerController {
	
	private static ManagerServices ms = new ManagerServices();
	
	 public static void viewAllPending(Context ctx) {    
	    	ctx.result("list");
	    }
	    public static void viewAllResolved(Context ctx) {    
	    	ctx.result("list");
	    }
	    public static void viewAllEmployees(Context ctx) {    
	    	ctx.result("list");
	    }
	    public static void viewReByUserId(Context ctx) {    
	    	int reid = Integer.parseInt(ctx.pathParam("id"));
			Reimbursements r = null;
			if (r != null) {
				ctx.json(r);
				ctx.status(HttpCode.OK);
			} else {
				ctx.status(HttpCode.NOT_FOUND);
			}
		}

	  
	    public static void updateReStatus(Context ctx) {    
	    	ctx.result("list");
	    }
	    
	    public static void viewAll(Context ctx) {
	    	ctx.result("list");
	    }

}
