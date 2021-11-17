package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao{
	

	@Override
	public boolean submitMyRequest(Reimbursements re) {
		String sql = "insert into reimbursements(recreator, reamount, resubmitted, reresolved, redescription)"
					+ "values (?, ?, ?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, re.getReCreator().getUname());
			ps.setDouble(2, re.getReAmount());
			ps.setBoolean(3, re.isReSubmitted());
			ps.setBoolean(4, re.isReResolved());
			ps.setString(5, re.getReDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				return false;
	}

	@Override
	public ArrayList<Reimbursements> viewMyPending(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursements> viewMyResolved(User u) {
		// TODO Auto-generated method stub
		return null;
	}


}
