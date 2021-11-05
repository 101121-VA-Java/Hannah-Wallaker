package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres {
	
		public User getUsername(String username){
			User u = null;
				try {
					Connection conn = ConnectionUtil.getConnectionFromFile();
					String sql = "select * from users where username = ? ";
					PreparedStatement  ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						return u;
					}						
					
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		
		public void addUser(User u) {
			try {
				Connection conn = ConnectionUtil.getConnectionFromFile();
				String sql = "insert into users (username, pword, uname, urole) values (?, ?, ?, ?)";
				PreparedStatement  ps = conn.prepareStatement(sql);
				String Role = u.getUsername();
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPassword());
				ps.setString(3,u.getName());
				ps.setString(4, Role);			
				
				ps.executeUpdate();
			
		}
			 catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


	}

