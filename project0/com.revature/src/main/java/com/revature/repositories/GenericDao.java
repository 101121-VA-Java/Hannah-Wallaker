package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface GenericDao<U> {
	
	// needs to add, getById, getAll, update, and delete
	
	void add(String username, String password, String name);
	boolean getByUsername(String username);
	List<U> getAll();
	boolean update(U u);
	boolean remove(U u);
}
