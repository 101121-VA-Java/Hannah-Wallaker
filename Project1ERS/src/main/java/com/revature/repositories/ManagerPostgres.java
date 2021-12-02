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


	@Override
	public boolean updateRequest(int statusid) {
		
		String sql = "update reimbursements set restatus = ? where reid = ?;";
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, statusid);
			ps.executeUpdate();
			return true;
		}catch (SQLException | IOException e) {			
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public ArrayList<Reimbursements> viewAllResolved() {
		String sql = "select * from reimbursements where restatus = 1;";
		ArrayList<Reimbursements> resolvedList = new ArrayList<Reimbursements>();
			
			try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while ( rs.next() ) {		
					Reimbursements re = new Reimbursements(rs.getInt("reId"), rs.getString("reCreator"), 
							rs.getDouble("reAmount"), rs.getString("reDescription"), 
							rs.getInt("statusId"), rs.getInt("typeId"));
					resolvedList.add(re);
				}
				
				}
				catch (SQLException | IOException e) {			
					e.printStackTrace();			
				}
				return resolvedList;
	}

	@Override
	public ArrayList<Reimbursements> viewSpecificRequest(String username) {
		
		String sql = "select * from reimbursements r join users u on "
					+ "u.uname = r.recreator where u.uname = ?;";
		ArrayList<Reimbursements> re = new ArrayList<Reimbursements>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				User u = new User();
				u.setUsername(rs.getString("uname"));
				Reimbursements Re = new Reimbursements(rs.getInt("reid"), rs.getString("recreator"), 
						rs.getDouble("reamount"), rs.getString("redescription"), 
						rs.getInt("statusid"), rs.getInt("typeid"));
				re.add(Re);
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
	
	@Override
	public ArrayList<Reimbursements> viewAllReimbursements(){
	ArrayList<Reimbursements> re = new ArrayList<Reimbursements>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from reimbursements;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursements Re = new Reimbursements(
						rs.getInt("reid"),
						rs.getString("recreator"), 
						rs.getDouble("reamount"), 
						rs.getString("redescription"), 
						rs.getInt("restatus"),
						rs.getInt("retype"));
				re.add(Re);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return re;
	}
	
	
}
