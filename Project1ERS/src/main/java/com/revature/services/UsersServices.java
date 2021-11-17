package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.repositories.UsersDao;
import com.revature.repositories.UsersPostgres;

public class UsersServices {
	
	private UsersDao ud;
	
	public UsersServices() {
		ud = new UsersPostgres();
	}
	
	public String loginSystem(String username, String password) throws IOException, SQLException {
		
		User loggedin = null;
		
		loggedin = ud.getUserByUsername(username);
		
		if(loggedin != null) {
			if(loggedin.getPassword().equals(password)) {
				return "LoggingIn";
			}
			else {
				return "Invalid login";
			}
		}else {
			return "Error logging in";
		}
	}

}
