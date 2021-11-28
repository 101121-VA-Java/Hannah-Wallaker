package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UsersDao;
import com.revature.repositories.UsersPostgres;

public class AuthServices {

	private UsersDao ud = new UsersPostgres();

	public String login(String username, String password) {
		User u = getUserByUsername(username);
		String token = null;

		if (u != null && u.getPassword().equals(password)) {

			token = u.getUserId() + ":" + u.getRole().getRoleId();
		}
		return token;
	}

	private User getUserByUsername(String username) {
		return ud.getUserByUsername(username) ;
	}

	
}
