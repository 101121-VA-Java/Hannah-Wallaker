package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.UsersController;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
			Javalin app = Javalin.create( (config) -> {
				config.enableCorsForAllOrigins();
				config.defaultContentType = "application/json";

			}).start();
			
			app.before(ctx -> {
			    ctx.header("Access-Control-Allow-Headers", "Authorization");
			    ctx.header("Access-Control-Expose-Headers", "Authorization");
			});
		
		app.routes(() -> {
			
			path("auth", () -> {
				post(AuthController::loginSystem); //Employees and Managers can login
			});
			path("account", () -> {
					get(UsersController::viewMyInfo); //view info
					put(UsersController::updateMyInfo); //update info
				});

			
			path("reimbursement", () -> {
				post(EmployeeController::submitMyRequest); // Employees can submit
				put(ManagerController::updateReStatus); //Managers can accept or deny requests
				get(ManagerController::viewAll);
			});
			path("pending", () -> {
				path("manager", () -> {
					get(ManagerController::viewAllPending); //Managers can get all pending requests
				});
				path("{username}", () -> {
					get(EmployeeController::viewMyPending); //Employees can view their pending
				});
			});
			
			path("resolved", () -> {
				path("manager", () -> {
					get(ManagerController::viewAllResolved); // Managers can view all resolved
				});
				path("{username}", () -> {
					get(EmployeeController::viewMyResolved); // Employees can view their resolved
				});
			});
			
			path("{id}", () -> {
				get(ManagerController::viewReByUserId); // Managers can view requests per employee
			});
			
			path("employees", () -> {
				path("all", () -> {
					get(ManagerController::viewAllEmployees);
				});
			});
			
		});
			

	}
}

	 

