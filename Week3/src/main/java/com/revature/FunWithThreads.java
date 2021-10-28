package com.revature;

public class FunWithThreads {
	
	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new FriendlyThread());
		Thread t2 = new Thread(new AngryThread());
		
		t1.start();
		t2.start();
		
	}

}
