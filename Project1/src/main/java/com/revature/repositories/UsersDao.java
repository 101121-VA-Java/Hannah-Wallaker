package com.revature.repositories;

import com.revature.models.Users;

public interface UsersDao {
	
	//employees and managers can login and logout
	boolean loginUsers(Users u);
	
	//employees can view their info, update their info
	Users viewMyInfo (Users u);
	Users updateMyInfo (Users u);
	
	
	
	//managers can view all employees
	Users viewAllEmployees();
	

}
