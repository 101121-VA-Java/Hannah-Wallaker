package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

//import javax.security.auth.login.LoginException;

import com.revature.models.User;
import com.revature.repositories.UserDaoInt;
import com.revature.repositories.UserPostgres;

public class UserServices {
	private UserDaoInt ud;
	private UserPostgres up;
	
	public UserServices() {
		up = new UserPostgres();
	}
	
	public String addUser(User u) {
		String userAdded = "Sorry, we were unable to create an account for you.";
		try {		
		up.addUser(u);
		//return "true";
		return null;
	} catch(SQLException e){
		if(e.getMessage().contains("duplicate key value")) {
			return "Looks like you already have an account!";
	}
	}catch(IOException e) {
		e.printStackTrace();
	}
		return userAdded;
	}
	

	public String loginSystem(String username, String password, String name){
		
		User loggedIn = null;
		try{
			loggedIn = up.getUsername(username);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (IOException e){
			if (e.getMessage().contains("duplicate key value")) {
				return "Looks like you already have an account with us!";
			}
		}
	
		if (loggedIn != null) {
		if(loggedIn.getPassword().equals(password)) {
			User.u = loggedIn;
			return "logginsuccess";
		}
		else { 
			return "Sorry, invalid password";
		}
	}
		
		else { return "Sorry, invalid username";
		}
		

	}


	
	}

