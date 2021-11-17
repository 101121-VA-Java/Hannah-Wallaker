package com.revature.repositories;

import com.revature.models.User;

public interface UsersDao {

	User getUserByUsername(String username);
	User viewMyInfo(User u);
	User updateMyInfo(User u);

	
	
}
