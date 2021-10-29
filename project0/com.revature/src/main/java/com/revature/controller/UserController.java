package com.revature.controller;

import java.util.Scanner;

import com.revature.exceptions.*;
import com.revature.models.*;
import com.revature.services.UserService;

public class UserController {

	private static UserService us = new UserService();
	private static User customer;
	private static Scanner scan;

	

	public static void registerUser(Scanner scan) {
		System.out.println("Welcome! Please enter a username: ");
		String username = scan.nextLine();
		System.out.println("Great! Nice to meet you, " + username + "! Please also enter a password: ");
		String password = scan.nextLine();
		System.out.println("Registered! Please enter your first name to complete: ");
		String name = scan.nextLine();

		User newUser = new User(name, username, password);
		
		try {
			newUser = us.addUser(newUser);
			System.out.println("Welcome to our family! " + newUser.getName());
		} catch  (UsernameAlreadyActiveException e) {
			System.out.println("Username is already taken. Please try again!");
		}
		
	//	us.addUser(newUser);

	// 	System.out.println("All set. User has been added.");
	}

	public void loginSystem(Scanner login) {
		scan = login;
		
		System.out.println("Glad to see you back! Please enter your username!");
		String username = scan.nextLine();
		System.out.println("And please also enter your password:");
		String password = scan.nextLine();
		System.out.println("Enter your name and you're good to go!");
		String name = scan.nextLine();
		
		try {
			customer = us.loginSystem(username, password, name);
			
		}catch (LoginException e) {
			System.out.println("Sorry, we don't recognize you, try again?");
		}
		
		
		
	}

		
	
	
/*	public void searchForUser() {
		// scanner getting user input
		try {
			User u = us.getByUsername(null);
		} catch (UserNotFoundException e) {
			System.out.println("User doesn't exist.");
			e.printStackTrace();
		}

	}
*/
	
	
	
	
	
}
