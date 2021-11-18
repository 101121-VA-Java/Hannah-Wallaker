package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.controllers.AuthController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Routes {
	
	public void run() {
		Javalin app = Javalin.create( (config) -> {
			config.enableCorsForAllOrigins();
			config.defaultContentType = "application/json";
		});
		app.start();
		
		app.before(ctx -> {
			ctx.header("Access-Controll-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});
		
		app.routes(() -> {
			
			path("auth", () -> {
				post(AuthController::loginSystem);
			});
			
		});
	}

}
