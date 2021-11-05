package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

//import javax.security.auth.login.LoginException;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserServices {
	private UserDao ud;
	private UserPostgres up;
	
	public UserServices() {
		up = new UserPostgres();
	}
	
	public String addUser(User u) throws SQLException, IOException {
		String userAdded = "Sorry, we were unable to create an account for you.";
				
		up.addUser(u);
		//return "true";
		return userAdded;
	}
	

	public String loginSystem(String username, String password, String name) throws SQLException, IOException {
		
		User loggedIn = null;
		loggedIn = up.getUsername(username);
	
		if (loggedIn != null) {
		if(loggedIn.getPassword().equals(password)) {
			User.u = loggedIn;
			return "logginsuccess";
		}
		else { return "Sorry, invalid password";
		}
	}
		
		else { return "Sorry, invalid username";
		}
		

	}


	
	
	//	private boolean getUsername(String username) {
		// TODO Auto-generated method stub
//		return false;
	}

