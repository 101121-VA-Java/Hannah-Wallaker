package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UsersDao;
import com.revature.repositories.UsersPostgres;

public class UsersServices {
	
	private UsersDao ud;
	
	public UsersServices() {
		ud = new UsersPostgres();
	}
	
	public boolean loginSystem(User u) {
		if(ud.loginSystem(u)) {
			return true;
		}
		return false;
	}

}
