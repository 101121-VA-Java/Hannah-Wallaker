package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.services.MembershipsServices;

public class EmployeeController {

	public static void employeeController(Scanner sc) {
		boolean run = true;
		
		while(run) {
			System.out.println("Hey, teammate! What are you trying to do?");
			System.out.println("1. Add a new membership");
			System.out.println("2. Remove a membership");
			System.out.println("3. Take a look at pending offers");
			System.out.println("4. View all payments");
			System.out.println("5. logout");
			
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				addMemberships(sc);
				break;
			case "2":
				removeMemberships(sc);
				break;
			case "3":
				customerOffers(sc);
				break;
			case "4":
				viewAllPayments(sc);
				break;
			case "5":
				run = false;
				break;
			default:
				System.out.println("Sorry, I don't understand.");
			}
		}
	}

	private static void viewAllPayments(Scanner sc) {
		MembershipsServices mems = new MembershipsServices();
		mems.viewMemberPayments();
		
	}

	private static void customerOffers(Scanner sc) {
		MembershipsServices mems = new MembershipsServices();
		ArrayList<MemberOffers> displayListMemberOffers = mems.customerOffers();
		System.out.println("Please choose the ID number for the offer you would like to update");
		int offerId = sc.nextInt();
		System.out.println("Would you like to accept or reject this offer?");
		boolean decision = sc.nextBoolean();
		if(decision) {
			for (MemberOffers mo : displayListMemberOffers) {
				if(mo.getOfferId() == offerId) {
					mems.acceptRejectOffer(offerId, true, mo.getOfferId());
				}
			}
		}
	}

	private static void removeMemberships(Scanner sc) {
		MembershipsServices mems = new MembershipsServices();
		ArrayList<Memberships> displayListMemberships = mems.getAllMemberships();
		if (displayListMemberships != null) {
			for(Memberships mem : displayListMemberships) {
				System.out.println(mem);
			}
		System.out.println("Select a MemId to remove it from our active memberships");
		int memId = sc.nextInt();
		MembershipsServices membs = new MembershipsServices();
		membs.removeMemberships(memId);
		}
		else{
			
			System.out.println("Sorry, we are experiencing an error");
		}
		
	}

	private static void addMemberships(Scanner sc) {
		System.out.println("Enter a price for the new Membership in whole dollars");
		int memprice = sc.nextInt();
		System.out.println("Enter a name for the new Membership");
		String memname = sc.nextLine();
		System.out.println("How long will this membership run?");
		String memlength = sc.nextLine();
		System.out.println("And are there any exceptions or limitations to thos Membership?");
		String memexceptions = sc.nextLine();
		
		Memberships newmem = new Memberships(memprice, memname, memlength, memexceptions);
		MembershipsServices memser = new MembershipsServices();
		
		if(memser.addMemberships(newmem) == false) {
			System.out.println("Add unsuccessful");
		}else {
			System.out.println("Membership added successfully!");
		}
		
	}
	
	

}
