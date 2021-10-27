package com.revature.repositories;

import java.util.List;

public interface GenericDao<U> {
	
	// needs to add, getById, getAll, update, and delete
	
	U add(U u);
	U getById(int id);
	List<U> getAll();
	boolean update(U u);
	boolean remove(U u);
}
