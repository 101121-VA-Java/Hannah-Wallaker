package com.revature.controller;

import java.util.Scanner;

public class FrontController {
	
	private Scanner sc;
	private UserController uc;
	private CustomerController co; 
	
	public FrontController() {
		sc = new Scanner(System.in);
		uc = new UserController();
	}
	
	public void execute() {
		boolean execute = true;
		
		while(execute) {
			System.out.println("Welcome to Wallaker's Bookmine! Please select an option from our menu: ");
			System.out.println("1. Register for an account with us");
			System.out.println("2. Login to an existing account");
			System.out.println("3. Exit the application");

			
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				UserController.registerUser(sc);
				//TODO... if a user is not registered, display an error message
				break;
			case "2":
				uc.loginSystem(sc);
				co.customerOptions(sc);
				//TODO... temporary login method until I can add and keep users
				break;
			case "3":
				System.out.println("Hope to see you again soon!");
				execute = false;
				break;
			default:
				System.out.println("Sorry... didn't catch that. Please select an option from our menu!");
			}
		}
		
		
	}

}
