package com.revature;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.controllers.FrontController;


public class Driver {
	
	public static void main(String[] args) throws SQLException, IOException {
		FrontController fc = new FrontController();
		fc.landingPage();
	}

}
