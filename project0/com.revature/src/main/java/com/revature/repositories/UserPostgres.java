package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao {

	
	public void addUser() {
				
	}
	
	
	
	@Override 
	public void add(String username, String password, String name) {
		try {
			Connection conn = ConnectionUtil.getConnectionFromFile();
			String sql = "insert into users (username, pword, uname, urole) values (?, ?, ?, ?)";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,name);
			ps.setString(4, Role.CUSTOMER.toString());			
			
			ps.executeUpdate();
		
	}
		 catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getByUsername(String username) {
		try {
			Connection conn = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from users where username = ? ";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}						
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}






}
