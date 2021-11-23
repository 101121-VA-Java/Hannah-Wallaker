package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UsersPostgres implements UsersDao {

	@Override
	public User getUserByUsername(String uname) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from users where uname = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User(
						rs.getInt("userId"),
						rs.getString("uname"),
						rs.getString("pword"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("email"), 
						null
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}

	
	
	
	@Override
	public User viewMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public User getUserById(int userId) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from users where userId = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User(
						rs.getInt("userId"),
						rs.getString("uname"),
						rs.getString("pword"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("email"), 
						null
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	

}
