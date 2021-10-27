package com.revature.daos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserList;

public class UserDaoTest {
	
	private UserDao ud = new UserList();
	
	@BeforeEach
	public void setUp() {
		ud = new UserList();
		
	}
	
	@Test
	public void getAll() {
		List<User> expected = new ArrayList<>();
		expected.add(new User(0, "Hannah", "HanWall", "123456", Role.CUSTOMER, null, null, null));
		assertEquals(expected, ud.getAll());
		
	}
	
	@Test
	public void getUserByIdExist() {
		List<User> expected = new ArrayList<>();
		expected.add(new User(0, "Hannah", "HanWall", "123456", Role.CUSTOMER, null, null, null));
		assertEquals(expected, ud.getById(0));
	
}
	
	@Test
	public void getUserByIdDoesNotExist() {
		assertEquals(null, ud.getById(10));
		
	}
	
	@Test
	public void addUser() {
		List<User> expected = new ArrayList<>();
		expected.add(new User(0, "Hannah", "HanWall", "123456", Role.CUSTOMER, null, null, null));
		expected.add(new User(1, "HanHan", "itmehanhan", "pass", Role.EMPLOYEE, null, null, null));
	
	ud.add(expected.add(new User(0, "HanHan", "itmehanhan", "pass", Role.EMPLOYEE, null, null, null)));
	assertEquals(expected, ud.getAll());
	
	}
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
