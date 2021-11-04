package com.revature;

import com.revature.controller.FrontController;
import com.revature.exceptions.UsernameAlreadyActiveException;

public class Driver {
	
	public static void main(String[] args) throws UsernameAlreadyActiveException {
		FrontController fc = new FrontController();
		fc.execute();
	}

}
