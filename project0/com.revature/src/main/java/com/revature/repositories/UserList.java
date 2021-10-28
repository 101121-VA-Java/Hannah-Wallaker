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
		
	}

	@Override
	public User add(User u) {
		//generates user id
		u.setId(users.size());
		//returns if adding was successful
		users.add(u);
		return(u);
		
	}

	@Override
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
		User undeclared = getById(u.getId());
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
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
}
