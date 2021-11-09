package com.revature;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.services.MembershipsServices;

public class MembershipsServicesTest {
	
	private static MembershipsServices ms;
	
	@Test
	public void getAllMemberships() throws SQLException, IOException {
		boolean actual = false;
		if(ms.getAllMemberships() != null) {
			actual = true;
		}
		boolean expected = true;
		assertEquals(expected, actual);
	}

}
