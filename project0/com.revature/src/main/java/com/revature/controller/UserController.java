package com.revature.controller;

import java.util.Scanner;

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
		public void registerUser(Scanner scan) {
			System.out.println("Welcome! Please enter a username: ");
			String username = scan.nextLine();
			System.out.println("Great! Nice to meet you, " + username + "! Please also enter a password: ");
			String password = scan.nextLine();
			System.out.println("Registered! Please enter your first name to complete: ");
			String name = scan.nextLine();
			
			User newUser = new User(name, username, password);
			
			
			//TODO check whether a user was created or not
			us.addUser(newUser);
			
			System.out.println("All set. User has been added.");
		}
		
		

}
