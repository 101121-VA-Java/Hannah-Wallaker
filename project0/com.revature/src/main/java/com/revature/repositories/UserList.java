package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.*;

public class UserList implements UserDao{

	private List<User> users;
	
	public UserList() {
		users = new ArrayList<>();
		//
		//
		User Owner = new User (0, "wallaker", "wallaker", "wallaker", Role.OWNER, null, null, null);
		users.add(Owner);
		
	}

	public User add(User u) {
		//generates user id
		u.setId(users.size());
		//returns if adding was successful
		users.add(u);
		return u;
		
	}
	
	@Override
	public User getByUsername(String username) {
		for(User u : users) {
			if(u.getUsername() == username) {
				return u;
			}
		}return null;
	}

	/*@Override
	public User getById(int id) {
		//Iterates to see if employees contain the id
		for(User u : users) { // enhanced for loop because we do not know the array size
			if(u.getId() == id) {
				return u;
			}
		}
		//otherwise we will want to return null
		return null;
	}
	*/

	@Override
	public List<User> getAll() {
		//return all users
		return users;
	}

	@Override
	public boolean update(User u) {
		//want true or false if user was updates
		User undeclared = getByUsername(u.getUsername());
		if (undeclared == null || undeclared.equals(u)) {
			return false;
		}
		users.set(u.getId(), u);
		return true;
	}

	@Override
	public boolean remove(User u) {
		//add later
		return false;
	}

	@Override
	public User getById(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}return null;
	}


	
	
	
	
	
	
}
