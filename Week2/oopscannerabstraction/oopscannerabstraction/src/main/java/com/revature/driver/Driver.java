package com.revature.driver;

import java.time.LocalDate;
import java.util.Scanner;

//import com.revature.models.Task;
//import com.revature.models.ImportantTask;
//import com.revature.models.BoringTask;
//import com.revature.models.UnimportantTask;
//import com.revature.models.User;
import com.revature.models.*;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Driver.loginScreen();
		
		Driver.taskList();
		
	}
		
		public static void loginScreen() {
		
		String uname = "Hannah";
		String pass = "password";
		
		System.out.println("Hello! Please enter your username");
		String username = sc.nextLine();
		
		System.out.println("Please enter your password");
		String password = sc.nextLine();
		
		if(uname.equals(username) && pass.equals(password)) {
			System.out.println("Welcome!");
		}else {
			System.out.println("Invalid entry");
		sc.close();
			
		}
		
	}

	

	public static void taskList() {

		Task t1 = new Task("Grocery Shopping and Fridge Clean out", LocalDate.now().plusDays(7));
		Task t3 = new BoringTask("Clean out closet");
		Task t4 = new ImportantTask("Programming Homework", LocalDate.now());
		Task t5 = new DailyTask("Do dishes");


		System.out.println("Reenter your username to check your tasks.");
		String importance = sc.nextLine();
		while(importance != "daily") {
			System.out.println("Rate Task Importance (normal, important, boring, or daily):");
			String choice = sc.nextLine();

			switch(choice) {
		
			case "normal":
				System.out.println(t1);
				break;
			
			case "important":
				System.out.println(t4);
				break;
			
			case "boring":
				System.out.println(t3);
				break;
			
			case "daily":
				System.out.println(t5);
				break;
			
			default:
				System.out.println("Invalid Choice");
				break;

			}
			
			System.out.println("Type 'next' to see next tasks: ");
			importance = sc.nextLine();
		}

		

	}
}