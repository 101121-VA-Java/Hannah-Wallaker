package com.revature;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.repositories.MembershipsPostgres;
import com.revature.services.MembershipsServices;

public class MembershipsServicesTest {
	
	private static MembershipsServices ms;
	private static MembershipsPostgres mp;
	
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
		mp = new MembershipsPostgres();
		
	}

	@After
	public void tearDown() {
		System.out.println("AfterAll");
	}

	
	
	@Test
	public void viewAllMemberships() throws SQLException, IOException {
		boolean actual = false;
		if(mp.viewAllMemberships() != null) {
			actual = true;
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}

	
	@Test	
	public void getWeeklyPayments() {
		boolean actual = false;
		try {
			if (mp.getWeeklyPayments() != null) {
			actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void viewMyMemberships() {
		boolean actual = false;
		try {
			if (mp.viewMyMemberships(0) != null) {
				actual = true;
			}	} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		boolean expected = true;
		assertEquals(expected, actual);
	
}
	
	@Test
	public void customerOffers() {
		boolean actual = false;
		try {
			if(mp.customerOffers() != null) {
				actual = true;
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		boolean expected = true;
		assertEquals(expected, actual);
	}
}
