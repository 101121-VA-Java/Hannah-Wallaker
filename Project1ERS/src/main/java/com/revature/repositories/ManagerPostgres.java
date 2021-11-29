package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao{

	@Override
	public ArrayList<Reimbursements> viewAllPending() {
		String sql = "select * from reimbursements where restatus = 0;";
	ArrayList<Reimbursements> pendingList = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while ( rs.next() ) {		
				Reimbursements re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
						rs.getDouble("reAmount"), rs.getString("reDescription"), 
						rs.getInt("statusId"), rs.getInt("typeId"));
				pendingList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
			return pendingList;

	}
	
	//review!!

	@Override
	public boolean updateRequest(Reimbursements re) {
		
		return false;
	}
//		String sql = "update reimbursements set recreator = ?, reamount = ?, "
//				+ "redescription = ?, restatus = ?, retype = ? where reid = ?;" ;
//		
//		int rowsChanged = -1;
//		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setString(1, re.getReCreator());
//			ps.setDouble(2, re.getReAmount());
//			ps.setString(3, re.getReDescription());
//			ps.setInt(4, re.getReStatus());
//			ps.setInt(5, re.getReType());
//			ps.setInt(6,  re.getReId());
//
//			rowsChanged = ps.executeUpdate();
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
//		if (rowsChanged > 0) {
//			return true;
//		} else {
//			return false;
//		}
//	}


	@Override
	public ArrayList<Reimbursements> viewAllResolved() {
		String sql = "select * from reimbursements where restatus = 1;";
		ArrayList<Reimbursements> pendingList = new ArrayList<Reimbursements>();
			
			try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while ( rs.next() ) {		
					Reimbursements re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
							rs.getDouble("reAmount"), rs.getString("reDescription"), 
							rs.getInt("statusId"), rs.getInt("typeId"));
					pendingList.add(re);
				}
				
				}
				catch (SQLException | IOException e) {			
					e.printStackTrace();			
				}
				return pendingList;
	}

	@Override
	public Reimbursements viewSpecificRequest() {
		Reimbursements re = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from Reimbursements where recreator = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {		
				re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
						rs.getDouble("reAmount"), rs.getString("reDescription"), 
						rs.getInt("statusId"), rs.getInt("typeId"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return re;
	}

	@Override
	public ArrayList<User> viewAllEmployees(){
		ArrayList<User> emps = new ArrayList<User>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from users u join userrole r on "
					+ "u.uname = r.uname where r.urole = 'Employee';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				User e = new User(rs.getInt("userId"), rs.getString("uname"),
						rs.getString("pword"), 
						rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("email"), rs.getInt("roleId"), 
						 rs.getString("urole"));
				emps.add(e);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emps;
	}
	
	
}
