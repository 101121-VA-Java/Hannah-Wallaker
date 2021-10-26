package com.revature.repositories;

import com.revature.models.User;

public class UserArray implements UserDao {

	private User[] users;
	
	public UserArray() {
		super();
		
	}
	
	public UserArray(User[] users) {
		this.users = users;
	}
	
	@Override
	public User[] getAllUsers() {
		return this.users;
	
}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User u) {
		
		// Create a temp array of size users + 1
		User[] temp = new User[users.length +1 ];
		
		int i = 0;
		
		for(; i < users.length; i++) {
			temp[i] = users[i];
		}
		/*
		 *  i is the value of the last index of the new array (users.length)
		 *  set i to be the id for the new user
		 */
		u.setId(i);
		
		// adding the new user to the array
		temp[i] = u;
		
		/*
		 * assign the newly created array to user
		 */
		users = temp;
		
		return i;
	}

	@Override
	public boolean editUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
	
