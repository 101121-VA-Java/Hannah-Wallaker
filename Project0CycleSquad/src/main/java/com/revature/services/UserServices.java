package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

//import javax.security.auth.login.LoginException;

import com.revature.models.User;
import com.revature.repositories.UserDaoInt;
import com.revature.repositories.UserPostgres;

public class UserServices {
	private UserDaoInt ud;
	private UserPostgres up;

	public UserServices() {
		up = new UserPostgres();
	}

	public String newUser(User u) {
		String userAdded = "Sorry, we were unable to create an account for you.";
		try {
			up.addUser(u);
			return "true";
		}

		// return null;
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAdded;
	}

	public String loginSystem(String username, String pword, String uname) throws SQLException, IOException {

		User loggedIn = null;

	//	try {
			loggedIn = up.getUsername(username);
			
	
	

//		} catch (SQLException e) {
//			return "Error retrieving data";
//		} catch (IOException e) {
//			if (e.getMessage().contains("duplicate key value")) {
//				return "Error retrieving data";
//			}
//		}
			if (loggedIn != null) {
				if (loggedIn.getPword().equals(pword)) {
					User.u = loggedIn;
					return "loginsuccess";

				} else {
					return "Invalid login credentials";
				}

			} else {
				return "Cannot locate username";
			}

	}
}
//
//		}
//	}



/*
 * loggedIn = up.getUsername(username);
 * 
 * if (loggedIn != null) { if(loggedIn.getPassword().equals(password)) { User.u
 * = loggedIn; return "logginsuccess"; } else { return
 * "Sorry, invalid password"; } }
 * 
 * else { return "Sorry, invalid username"; }
 * 
 * 
 * }
 * 
 */
