package com.revature.controller;

import java.io.File;
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

		// TODO check whether a user was created or not
		us.addUser(newUser);

		System.out.println("All set. User has been added.");
	}

	public void loginExisting(Scanner login) {
		String uname;
		String pword;

		pword = "123456";
		uname = "hannah";

		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter Username : ");
		String username = input1.next();

		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter Password : ");
		String password = input2.next();

		if (username.equals(uname) && password.equals(pword)) {

			System.out.println("Access Granted! Welcome!");
		}

		else if (username.equals(uname)) {
			System.out.println("Invalid Password!");
		} else if (password.equals(pword)) {
			System.out.println("Invalid Username!");
		} else {
			System.out.println("Invalid Username & Password!");
		}

	}

}
