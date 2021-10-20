package com.revature.models;

import java.time.LocalDate;

public class ExcitingTask extends Task {
	

	public ExcitingTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExcitingTask(String name, LocalDate dueDate) {
		super(name, dueDate);
		// TODO Auto-generated constructor stub
	}
	
	public void excitement() {
		this.setDueDate(this.getDueDate().minusWeeks(1));
	}
	public void excitement(int weeks) {
		this.setDueDate(this.getDueDate().minusWeeks(weeks));
	}
	
	public void excitement(int weeks, int times) {
		this.setDueDate(this.getDueDate().minusWeeks(weeks * times));
	}
	
	//@Override
	public String toString() {
		return "Task [name=" + name + ", dueDate=" + dueDate + "]";
	}
	
	public ExcitingTask getATask() {
		return new ExcitingTask();
	}
	
}