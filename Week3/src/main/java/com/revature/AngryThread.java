package com.revature;

class AngryThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Grrr, I am the angry thread");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("and I keep...");
		{

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("GETTING....");
			{

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("ANGRIER!!!");

			}

		}
	}
}