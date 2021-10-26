package com.revature.controller;

import com.revature.exceptions.*;
import com.revature.models.*;
import com.revature.services.UserService;

public class UserController {


		private UserService us = new UserService();
		
		public void searchForUser() {
			// scanner getting user input
			try {
				User u = us.getUserById(0);
			} catch (UserNotFoundException e) {
				System.out.println("User doesn't exist.");
				e.printStackTrace();
			} 

}

}
