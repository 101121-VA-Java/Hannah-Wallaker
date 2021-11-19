package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
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
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}

	@Override
	public ArrayList<Reimbursements> viewMyPending(User u) {
		String sql = "\r\n"
				+ "select * from reimbursements where recreator = ? "
				+ "and resubmitted = true and reresolved = false;";
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursements> pendingList = new ArrayList<Reimbursements>();
			while ( rs.next() ) {		
//				ReimbursementStatus reStatus = new ReimbursementStatus(rs.getInt("reimb_status_id"), false);
//				ReimbursementType reType = new ReimbursementType(rs.getInt("reimb_type_id"), sql);
//				
//				Reimbursements re = new Reimbursements(0, sql, u, null, null);
			}
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
			return null;

	}

	@Override
	public ArrayList<Reimbursements> viewMyResolved(User u) {
		String sql = "\r\n"
				+ "select * from reimbursements where recreator = ? "
				+ "and resubmitted = true and reresolved = false;";
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursements> resolvedList = new ArrayList<Reimbursements>();
			while ( rs.next() ) {		
//				ReimbursementStatus reStatus = new ReimbursementStatus(rs.getInt("reimb_status_id"), false);
//				ReimbursementType reType = new ReimbursementType(rs.getInt("reimb_type_id"), sql);
//				
//				Reimbursements re = new Reimbursements(0, sql, u, null, null);
			}
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
		
		return null;
	}


}
