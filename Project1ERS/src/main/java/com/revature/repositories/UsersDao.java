package com.revature.repositories;

import com.revature.models.User;

public interface UsersDao {
	
	//all users can login and logout
	User getUserByUsername(String username);
	
	
	//employees can view and update their info
	User viewMyInfo(User u);
	User updateMyInfo(User u);
	
	//managers can view all employees
	User viewAllEmployees();
	
	
}
