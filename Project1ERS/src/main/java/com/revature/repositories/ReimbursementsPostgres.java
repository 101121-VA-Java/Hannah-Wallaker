package com.revature.repositories;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.ReimbursementStatus;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementsPostgres implements ReimbursementsDao {

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

	@Override
	public ArrayList<Reimbursements> viewAllPending() {
		// TODO Auto-generated method stub
		return null;
	}
//OK Hannah... you probably need to take another look at those models. Unless you can just do this an 
//easier way where reStatus = true
	@Override
	public ArrayList<ReimbursementStatus> viewAllResolved() {
		Connection con = ConnectionUtil.getConnectionFromFile();
		String sql = "Select * from reimbursementstatus rs join reimbursements re where rs.reapproved = re.reresolved";
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<ReimbursementStatus> re = new ArrayList<ReimbursementStatus>();
		while(rs.next()) {
			Reimbursements reimb = new Reimbursements(rs.getInt("reId"), rs.getDouble("reamount"), rs.getBoolean("resubmitted"), rs.getBoolean("reresolved"), rs.getString("recreator"), null, null, null, null);
			re.add(reimb);
		}
			return re;
	}

	
//hmm I thought I was big brain there... look with fresh eyes tomorrow
	
	
	@Override
	public ArrayList<Reimbursements> viewSpecificResolved(User u) throws IOException, SQLException {
		
		
		
		return null;
	}

	@Override
	public boolean approveDeny(Reimbursements re) {
		// TODO Auto-generated method stub
		return false;
	}

}
