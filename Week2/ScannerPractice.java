package com.revature;

import java.util.Scanner;

public class ScannerPractice {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		menu();
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println("You have selected menu option " + num);
		
		while(num != 3 ) {
			if(num == 1) {
				long rn = Math.round(Math.random()*100); 
				System.out.println("Here is your number: " + rn);
				menu();
				num = sc.nextInt();
				sc.nextLine();
				System.out.println("You have selected menu option " + num + );
			}else if(num == 2) {
				StringBuffer sb = new StringBuffer (sc.nextLine());
				System.out.println("Here is your word: " + sb.reverse());
				menu();
				num = sc.nextInt();
				sc.nextLine();
				System.out.println("You have selected menu option " + num );
			}else {
				System.out.println("Invalid. Select an option from the menu.");
				menu();
				num = sc.nextInt();
				sc.nextLine();
			}
			
		}
		System.out.println("Goodbye!");
		
		/*
		 * System.out.println("Hello World!"); System.out.println("What's your name?");
		 * 
		 * String name = sc.nextLine();
		 * 
		 * System.out.println("Hello " + name); System.out.println("Pick a number:");
		 * 
		 * int num = sc.nextInt(); sc.nextLine(); // this sc.nextLine() flushes/grabs
		 * the leftovers from the previous input capture // String number =
		 * sc.nextLine(); // some validation // int num = Integer.parseInt(number);
		 * 
		 * System.out.println("You picked " + num);
		 * 
		 * 
		 * ScannerPractice.loginScreen();
		 * 
		 */
		// Please close your resources people
		sc.close();

		/*
		 * Create a menu that gives a user multiple options: - 1: get a random number -
		 * 2: Using StringBuffer, reverse a word of the user's choice - 3: exit the
		 * program This menu should repeat until the user decides to exit.
		 */
	}

	/*
	 * public static void loginScreen() { String uname = "admin"; String pass =
	 * "pass";
	 * 
	 * System.out.println("Please enter your username:"); String username =
	 * sc.nextLine(); System.out.println("Please enter your password:"); String
	 * password = sc.nextLine(); if(uname.equals(username) && pass.equals(password))
	 * { System.out.println("You're logged in."); } else {
	 * System.out.println("Not quite."); } }
	 */

	public static void menu() {
		System.out.println("Welcome! Please select from our menu below!");
		System.out.println("1. Get a random number");
		System.out.println("2. See your word in reverse");
		System.out.println("3. Exit");
		
		

	}
}
