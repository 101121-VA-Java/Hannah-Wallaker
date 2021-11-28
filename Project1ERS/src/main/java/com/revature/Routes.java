package com.revature;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;
import io.javalin.Javalin;

import com.revature.controllers.*;


public class Routes {
	
	public void run() {	
			Javalin app = Javalin.create( (config) -> {
				config.enableCorsForAllOrigins();
			
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
				path("info", () -> {
					get(UsersController:: viewMyInfo); //I feel like even managers should be 
													  // able to update their info, so making Users
				});
				path("info", () -> {
					put(UsersController:: updateMyInfo); //again users so both can
				});
			});
			
			path("reimbursement", () ->{
				post(EmployeeController:: submitMyRequest); // Employees can submit
				put(ManagerController:: updateReStatus); //Managers can accept or deny requests
			});
			path("pending", () -> {
				path("man", () -> {
					get(ManagerController :: viewAllPending); //Managers can get all pending requests
				});
				path("{id}", () -> {
					get(EmployeeController :: viewMyPending); //Employees can view their pending
				});
			});
			
			path("resolved", () -> {
				path("man", () -> {
					get(ManagerController:: viewAllResolved); // Managers can view all resolved
				});
				path("{id}", () -> {
					get(EmployeeController :: viewMyResolved); // Employees can view their resolved
				});
			});
			
			path("{id}", () -> {
				get(ManagerController:: viewReByUserId); // Managers can view requests per employee
			});
			
			path("employees", () -> {
				path("all", () -> {
					get(ManagerController :: viewAllEmployees);
				});
			});
			
		});
	}

}
