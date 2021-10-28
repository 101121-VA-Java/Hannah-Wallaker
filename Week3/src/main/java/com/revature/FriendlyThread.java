package com.revature;

class FriendlyThread implements Runnable {
	
	public void run() {
		System.out.println("I am the friendly thread");
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Oh hush, angry thread. You'll scare away our guest");
		
	}


		

}
