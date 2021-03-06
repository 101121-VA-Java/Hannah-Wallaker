package com.revature.services;

import java.time.LocalDate;

import com.revature.models.BoringTask;
import com.revature.models.DailyTask;
import com.revature.models.ImportantTask;
import com.revature.models.Task;
import com.revature.models.User;

public class Services {

	protected String s;
	String something; // default access modifier

	public void doEncapsulation() {
		User u = new User();
		u.setUsername("Hannah");
		u.setAge(23);
		User h = new User ();

		new Object();

		/*
		 * SYSO - calls u.toString() implicitely - default implementation of toString(),
		 * per the Object Class, is the memory address - to return meaning information,
		 * we have to override the method to be relevant to the fields of that class
		 * 
		 */
		System.out.println("u age: " + u.getAge());
		System.out.println(h);

		System.out.println("Is h.equals(u)? " + h.equals(u));
	}

	public void doInheritance() {
		User u = new User();
		Task t1 = new Task("Laundry", LocalDate.parse("2021-10-20"));
		System.out.println(t1);
		Task t3 = new Task ("Quiz", LocalDate.parse("2021-10-20"));
		System.out.println(t3);
		Task t4 = new Task ("Adopt a puppy!", LocalDate.parse("2021-10-20"));
		System.out.println(t4);
		
		u.setTask(t1);
		u.setTask(t3);
		u.setTask(t4);

		System.out.println(u);

		ImportantTask it = new ImportantTask("Quiz", LocalDate.now());

		it.stress();

		System.out.println(it);
	}

	/* public void doPolymorphism() {
		// method overriding
		Task t1 = new Task();
		t1.setName("Laundry");
		t1.setDueDate(LocalDate.now());
		System.out.println("This should print toString() from Task class: " + t1);

		ImportantTask t2 = new ImportantTask(something);
		t2.setName("Quiz");
		t2.setDueDate(LocalDate.now());
		String t3;
		System.out.println("This should print toString() from ImportantTask class: " + t3);

		DailyTask dt = new DailyTask(something);

		String t4;
		System.out.println("This should print toString() from BoringTask class: " + t4);

		DailyTask t5 = new DailyTask(something);
		t5.setName("Adopt a puppy!");
		t5.setDueDate(LocalDate.now());
		System.out.println("This should print toString() from DailyTask class: " + t5);
*/
				
		
/*		// Upcasting
		Task t = new BoringTask(something, null);
		Task it = new ImportantTask(something, null);
		

		Task[] tasks = t, it; {

		for (Task task : tasks) {
			System.out.println(task.toString());
		}
		
		BoringTask boring = (BoringTask) new Task();
		

	}
	*/
}