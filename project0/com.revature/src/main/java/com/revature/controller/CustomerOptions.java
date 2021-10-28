package com.revature.controller;

import java.util.Scanner;

public class CustomerOptions {

	public void customerOptions(Scanner scan) {

		boolean run = true;

		while (run) {
			System.out.println("Hello again! What would you like to do today?");
			System.out.println("1. View books available for purchase");
			System.out.println("2. View previous purchases");
			System.out.println("3. Navigate to payment portal");
			System.out.println("4. Send a message to our staff");
			System.out.println("5. Exit");

			String input = scan.nextLine();

			switch (input) {
			case "1":
				availableBooks(scan);
				break;
			case "2":
				viewPurchases(scan);
				break;
			case "3":
				paymentPortal(scan);
				break;
			case "4":
				messageSystem(scan);
				break;
			case "5":
				run = false;
				break;
			default:
				System.out.println("Sorry, didn't catch that. Please try again.");

			}

		}

	}

	private void messageSystem(Scanner scan) {
		// send a message to staff

		boolean run = true;

		while (run) {
			System.out.println("We'd love to hear from you!");
			System.out.println("Type 'Exit' to go back");

			String input = scan.nextLine();

			switch (input) {
			case "Exit":
				run = false;
				break;
			default:
				System.out.println("Drop us a line below!");

			}

		}

	}

	private void paymentPortal(Scanner scan) {
		// TODO Auto-generated method stub
		// pay here

	}

	private void viewPurchases(Scanner scan) {
		// TODO Auto-generated method stub
		// view past purchases

	}

	private void availableBooks(Scanner scan) {
		boolean run = true;

		while (run) {
			// Need to connect database here... sort by genre?
			System.out.println("1. View new arrivals");
			System.out.println("2. View classics");
			System.out.println("3. View Wallaker's recommendations");
			System.out.println("4. Exit");

			String input = scan.nextLine();

			switch (input) {
			case "1":
				System.out.println("Arrivals page under construction");
				break;
			case "2":
				System.out.println("Classics page under construction");
				break;
			case "3":
				System.out.println("Recommendations page under construction");
				break;
			case "4":
				run = false;
				break;
			default:
				System.out.println("yeah... workin on it");
			}

		}

	}

}
