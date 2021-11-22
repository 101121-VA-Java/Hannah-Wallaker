package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao{

	@Override
	public Reimbursements viewAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequest(Reimbursements re) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursements viewAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements viewSpecificRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewAllEmployees() throws IOException, SQLException {
		User u = null;
		Connection con = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from users u join userrole r on u.uname = r.uname "
				+ "where u.uname = ? ;" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			
			
		}
		
		
		return null;
	}

	
	
}
