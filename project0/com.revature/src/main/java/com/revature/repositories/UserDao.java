package com.revature.repositories;

import com.revature.models.User;

public interface UserDao extends GenericDao<User>{
	
	boolean getByUsername(String username);
	
	
	
}