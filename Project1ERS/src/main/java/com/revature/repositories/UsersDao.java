package com.revature.repositories;

import com.revature.models.User;

public interface UsersDao {
	


	User getUserByUsername(String username);
	User getUserById(int userId);
	boolean updateMyInfo(User u);
	User viewMyInfo(String username);

	
	

	
	
}
