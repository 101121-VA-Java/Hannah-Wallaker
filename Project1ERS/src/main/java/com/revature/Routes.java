package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Routes {
	
	public void run() {
		Javalin app = Javalin.create( (config) -> {
		}).start();
		
		app.routes(() -> {
			
			path("login", () -> {
				post(UserController::loginSystem);
			});
			
		});
	}

}
