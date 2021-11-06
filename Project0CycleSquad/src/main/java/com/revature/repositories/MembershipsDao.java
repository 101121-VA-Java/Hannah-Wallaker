/*package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Memberships;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class MembershipsDao {
	
	public Memberships getMemberships(String memname){
		Memberships mem = null;
			try {
				Connection conn = ConnectionUtil.getConnectionFromFile();
				String sql = "select * from users where memname = ? ";
				PreparedStatement  ps = conn.prepareStatement(sql);
				ps.setString(1, memname);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					return mem;
				}						
				
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}
*/