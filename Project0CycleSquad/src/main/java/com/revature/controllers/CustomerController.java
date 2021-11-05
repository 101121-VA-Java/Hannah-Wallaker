package com.revature.controllers;

import java.util.Scanner;

public class CustomerController {

	public void customerController(Scanner scan) {
		boolean run = true;
		
		while(run) {
			System.out.println("Riders like you make our wheels turn!");
			System.out.println("What are you looking to do today?");
			System.out.println("1. View our comprehensive list of membership options");
			System.out.println("2. Check your current and previous memberships");
			System.out.println("3. Navigate to payment portal");
			System.out.println("4. Exit");
			
			String cusChoice = sc.nextLine();
			
			switch(cusChoice) {
			case "1":
				membershipOptions(scan);
				break;
			case "2":
				viewMemberships(scan);
				break;
			case "3":
				paymentPortal(scan);
				break;
			case"4":
				run = false;
				break;
			default:
				System.out.println("Sorry, didn't catch that.");
			}
		}
		
	}
	
	private void membershipOptions(Scanner scan) {
		
	}

}
