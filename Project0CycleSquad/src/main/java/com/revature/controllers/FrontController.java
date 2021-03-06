package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserServices;

public class FrontController {
	
	Scanner sc = new Scanner(System.in);
	CustomerController customerController = new CustomerController();
	EmployeeController employeeController = new EmployeeController();
	
	public void landingPage() throws SQLException, IOException {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome to CycleSquad! Ready to ride?");
			System.out.println("Menu options:");
			System.out.println("1. Register a new rider");
			System.out.println("2. Login to an existing account");
			System.out.println("3. Exit out application");
			
			String menuChoice = sc.nextLine();
			
			switch(menuChoice) {
			case "1":
				registerNewUser(sc);
				break;
			case "2":
				loginUser(sc);
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Sorry, we didn't get that. Try again?");
			}
		}
		
		sc.close();
	}
	
	private void registerNewUser(Scanner sc) {
		boolean run = true;
		String username = "";
		String password = "";
		String name = "";
		
		while(run) {

				System.out.println("Welcome, new rider! Please enter a username for our leaderboards:");
				username = sc.nextLine();
				System.out.println("Sweet! Pick a password to secure your account");
				password = sc.nextLine();
				System.out.println("Awesome, " + username + "! Type your name and you're all set!");
				name = sc.nextLine();
				
			
			User u = new User(username, password, name, Role.CUSTOMER);
			UserServices us = new UserServices();
			String userAdded = us.newUser(u);
			if(userAdded == "true") {
				System.out.println("Welcome new rider!");
				run = false;
			}
			else {
				System.out.println(userAdded);
			}
		}
	
	
	}
	
	private void loginUser(Scanner sc) throws SQLException, IOException {
		boolean run = true;
		String username = "";
		String password = "";
		String name = "";
		
		while(run) {

			System.out.println("Welcome back! Please enter your username");
			username = sc.nextLine();
			System.out.println("And your password:");
			password = sc.nextLine();
			System.out.println("Sweet, " + username + ", enter your name and you're all set!");
			name = sc.nextLine();

		
			UserServices us = new UserServices();
			String returnLogin = us.loginSystem(username, password, name);
//			if(returnLogin.equals("logginsuccess")) {
				run = false;
				System.out.println("Great to see you again, " + User.u.getUname() + "!");
				
				if(User.u.getUrole() == Role.CUSTOMER) {
					CustomerController.customerController(sc);
				}
				else if(User.u.getUrole() == Role.EMPLOYEE) {
					EmployeeController.employeeController(sc);
				}
				
			}
//			else {
//				System.out.println(returnLogin);
//			}
		}
	}
	
	


