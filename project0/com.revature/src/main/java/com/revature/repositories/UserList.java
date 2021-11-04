package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.*;

public class UserList implements UserDao{

	private List<User> users;
	
	public UserList() {
		users = new ArrayList<>();
		
	}

	public void add(User u) {
		//generates user id
		u.setId(users.size());
		//returns if adding was successful
		users.add(u);
		//return u;
		
	}
	
	@Override
	public boolean getByUsername(String username) {
		for(User u : users) {
			if(u.getUsername() == username) {
				return true;
			}
		}return true;
	}

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

	@Override
	public List<User> getAll() {
		//return all users
		return users;
	}

	@Override
	public boolean update(User u) {
		//want true or false if user was updates
//		User undeclared = getByUsername(u.getUsername());
//		if (undeclared == null || undeclared.equals(u)) {
//			return false;
//		}
//		users.set(u.getId(), u);
		return true;
	}

	@Override
	public boolean remove(User u) {
		//add later
		return false;
	}

	@Override
	public void add(String username, String password, String name) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
