package com.revature.services;

import com.revature.exceptions.*;
import com.revature.models.*;
import com.revature.repositories.*;

public class UserService {
	

	private UserDao ud; 
	
	public int addUser(User u) {
		/*
		 * add business logic here to manipulate e before storage 
		 * (Done 10.26 u will be our basic user, customer)
		 * 
		 * When a user registers, we will collect their name, username, and password
		 * System should assign role Employee and Manager
		 * 
		 */
		
		u.setRole(Role.CUSTOMER);
		return ud.addUser(u);
	}
	
	public User getUserById(int id) throws UserNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}
	
	

}
