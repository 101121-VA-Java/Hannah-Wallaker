package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.User;

public interface UserDaoInt {
	
	public String addUser(User u);
	
	public User getUsername(String username);

}
