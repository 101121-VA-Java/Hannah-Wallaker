package com.revature.repositories;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres {
	
	Connection con = null;
	
		public User getUsername(String username) throws SQLException, IOException{
			User u = null;
					con = ConnectionUtil.getConnectionFromFile();
					String sql = "select * from users where username = '" + username + "';";
					java.sql.Statement state = con.createStatement();
					ResultSet rs = state.executeQuery(sql);
					
		while (rs.next()) {
			Role role = null;
			if(rs.getString("urole").equals("CUSTOMER")) {
				role = Role.CUSTOMER;
			} else if(rs.getString("urole").equals("EMPLOYEE")) {
				role = Role.EMPLOYEE;
		}else if (rs.getString("urole").equals("OWNER")) {
			role = Role.OWNER;
		}
			
			u = new User(rs.getString("username"), rs.getString("pword"), rs.getString("uname"), role);
			u.setId(rs.getInt("id"));
			return u;		
			
			}
		
		return null;
		
		}
		
		public void addUser(User u) throws SQLException, IOException{
	
				con = ConnectionUtil.getConnectionFromFile();
				String sql = "insert into users (username, pword, uname, urole) values (?, ?, ?, ?)";
				PreparedStatement  ps = con.prepareStatement(sql);
				String Role = u.getUsername();
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPword());
				ps.setString(3,u.getUname());
				ps.setString(4, Role);			
				
				ps.executeUpdate();
			
		
		}


	}

