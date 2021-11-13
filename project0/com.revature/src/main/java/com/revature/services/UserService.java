package com.revature.services;

import java.util.List;
import com.revature.exceptions.*;
import com.revature.models.*;
import com.revature.repositories.*;
import com.revature.services.*;

public class UserService extends UserList {

	private UserDao ud;
	private UserPostgres up;
	
	
	public UserService() {
		up = new UserPostgres();
	}
	
	public void addUser(User u) throws UsernameAlreadyActiveException {

	}

	
	public void loginSystem(String username, String password, String name) throws LoginException {
		
		UserService us = new UserService();
		boolean userExists = us.getByUsername(username);
		
		if (userExists) {
			up.add(username, password, name);
		//	up.addUser();
		}
		else {
			System.out.println("User already exists");
		}
		

	}

}
