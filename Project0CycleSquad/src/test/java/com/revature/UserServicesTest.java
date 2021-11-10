package com.revature;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.MembershipsPostgres;
import com.revature.services.UserServices;

public class UserServicesTest {
	
	private static UserServices us;
	
	@Before
	public void beforeEach() {
		System.out.println("Running before each test");
	}

	@After
	public void afterEach() {
		System.out.println("Running after each test");
	}

	@Before
	public void setup() {
		us = new UserServices();
		
	}

	@After
	public void tearDown() {
		System.out.println("AfterAll");
	}

	
	@Test
	public void newUser(){
		User u = new User("username", "password", "name", Role.CUSTOMER);
		String expected = "true";
		String actual = us.newUser(u);
		assertEquals(expected, actual);
	}
	
	@Test
	public void loginSystem() throws SQLException, IOException {
		User u = new User("username", "password", "name", Role.CUSTOMER);
		String expected = "logginsuccess";
		String actual = us.loginSystem(u.getUsername(), u.getPword(), u.getUname());
		assertEquals(expected, actual);
	}

}
