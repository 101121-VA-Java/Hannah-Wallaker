package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Memberships;
import com.revature.models.User;
import com.revature.services.MembershipsServices;

public class CustomerController {

	public static void customerController(Scanner scan) {
		boolean run = true;
		
		while(run) {
			System.out.println("Riders like you make our wheels turn!");
			System.out.println("What are you looking to do today?");
			System.out.println("1. View our comprehensive list of membership options");
			System.out.println("2. Check your current and previous memberships");
			System.out.println("3. Navigate to payment portal");
			System.out.println("4. Exit");
			
			String cusChoice = scan.nextLine();
			
			switch(cusChoice) {
			case "1":
				membershipOptions(scan);
				break;
			case "2":
				viewMyMemberships(scan);
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
	
	

	private static void membershipOptions(Scanner scan) {
		
		MembershipsServices memop = new MembershipsServices();
		ArrayList<Memberships> membershipoptions = memop.getAllMemberships();
		if(membershipoptions.size() != 0) {
			for(Memberships mems : membershipoptions) {
				System.out.println(mems);
			}
			
			System.out.println("Select the ID of a Membership Option to make an offer if none of our choices work for you!");
			int memChoice = scan.nextInt();
			System.out.println("Enter an amount in whole dollars you would like to offer:");
			int memCost = scan.nextInt();
		
			MembershipsServices mems = new MembershipsServices();
			mems.makeMyOffer(User.u, memChoice, memCost);
		}
		else {
			System.out.println("No memberships available");
		}
			
	}
	
	private static void viewMyMemberships(Scanner scan) {
		MembershipsServices mems = new MembershipsServices();
		mems.viewMyMemberships(User.u.getId());
		
	}

	
	private static void paymentPortal (Scanner scan) {
		MembershipsServices mems = new MembershipsServices();
		mems.viewMyPayments(User.u.getId());
	}
		


}
