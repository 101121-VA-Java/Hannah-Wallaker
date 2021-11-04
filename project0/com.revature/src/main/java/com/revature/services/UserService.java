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
	/*
	 * add business logic here to manipulate e before storage (Done 10.26 u will be
	 * our basic user, customer)
	 * 
	 * When a user registers, we will collect their name, username, and password
	 * System should assign role Employee and Manager
	 * 
	 */

	public void addUser(User u) throws UsernameAlreadyActiveException {

//		User newUser = this.getByUsername(u.getUsername());
//		if (newUser != null) {
//			throw new UsernameAlreadyActiveException();
//		}
		//return ud.add(u);
	}

	/*public User getByUsername(String username) {
		List<User> users = ud.getAll();
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

	}
	*/
	
	public  void loginSystem(String username, String password, String name) throws LoginException {
		
		UserService us = new UserService();
		boolean userExists = us.getByUsername(username);
		
		if (userExists) {
			up.add(username, password, name);
		//	up.addUser();
		}
		else {
			System.out.println("User already exists");
		}
		
					
//		User u = this.getByUsername(username);
//		if(u == null || !u.getPassword().equals(password)){
//			throw new LoginException();
//			} return u;
	}

}
