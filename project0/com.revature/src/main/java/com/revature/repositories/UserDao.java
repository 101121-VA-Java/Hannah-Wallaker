package com.revature.repositories;

import com.revature.models.Role;
import com.revature.models.User;

public interface UserDao{
	User[] getAllUsers(); // returns array of all users
	User getUserById(int id);
	int addUser(User u); // returns user id so no confusion on user
	boolean editUser(User u); // returns t or f if edit success
	boolean deleteUser(int id); // returns t or f for delete success
	
}