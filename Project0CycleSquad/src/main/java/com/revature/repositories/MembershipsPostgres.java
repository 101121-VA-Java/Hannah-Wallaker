package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.models.PaymentPortalEmployeeView;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class MembershipsPostgres implements MembershipsDaoInt {
	
	Connection con = null;

	@Override
	public ArrayList<Memberships> viewAllMemberships() throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "select memid, memprice, memname, memlength, memexception\r\n"
				+ "from memberships m\r\n"
				+ "except\r\n"
				+ "select m.memid, memprice, memname, memlength, memexception\r\n"
				+ "from memberships m\r\n"
				+ "join offers mo on mo.memid = m.memid\r\n"
				+ "where mo.userpaid = false;" ;
		
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<Memberships> memberships = new ArrayList<Memberships>();
		while(rs.next()) {
			Memberships mems = new Memberships(rs.getInt("memId"), rs.getInt("memprice"), rs.getString("memname"), rs.getString("memlength"), rs.getString("memexception"));
			mems.setMemId(rs.getInt("memid"));
			memberships.add(mems);
		}

		
		
//		String sql = "select * from memberships;";
//		Statement state = con.createStatement();
//		ResultSet rs = state.executeQuery(sql);
//		ArrayList<Memberships> memberships = new ArrayList<Memberships>();
//		while(rs.next()) {
//			Memberships mems = new Memberships(rs.getInt("memprice"), rs.getString("memname"), rs.getString("memlength"), rs.getString("memexceptions"));
//			memberships.add(mems);
//		}
		return memberships;
	}

	@Override
	public ArrayList<PaymentPortal> viewMyMemberships(int userId) throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "select distinct p.payId, p.memName, p.customerName, p.userPaid from payments p join offers mo on mo.userid =" + userId + "where p.userPaid = true;" ;
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<PaymentPortal> memberships = new ArrayList<PaymentPortal>();
		while(rs.next()) {
			PaymentPortal mems = new PaymentPortal(rs.getInt("payId"), rs.getString("memName"), rs.getString("customerName"), true);
			memberships.add(mems);
		}
		
		return memberships;
	}

	@Override
	public ArrayList<Memberships> viewMyPendingPurchases() throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from offers where;";
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<Memberships> memberships = new ArrayList<Memberships>();
		while(rs.next()) {
			Memberships mems = new Memberships(rs.getInt("memid"), rs.getInt("memprice"), rs.getString("memname"), rs.getString("memlength"), rs.getString("memexceptions"));
			mems.setMemId(rs.getInt("memid"));
			memberships.add(mems);
		}
		return memberships;
		
	}

	@Override
	public void makeMyOffer(User u, int memid, int offer) throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "insert into offers (userid, memid, offer) values (?, ?, ?);";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getId());
		ps.setInt(2, memid);
		ps.setInt(3, offer);
		ps.executeUpdate();
		
	}

	@Override
	public ArrayList<PaymentPortal> viewMyPayments(int userId) throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
	//	String sql = "select * from offers mo join users u on mo.userid = u.id join memberships m on m.memid = mo.memid where mo.userpaid = false";
		
		String sql = "select distinct p.payId, p.memName, p.customerName, p.userPaid from payments p join offers mo on mo.userid =" + userId + "where p.userPaid = false;" ;
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<PaymentPortal> memberships = new ArrayList<PaymentPortal>();
		while(rs.next()) {
			PaymentPortal mems = new PaymentPortal(rs.getInt("payId"), rs.getString("memName"), rs.getString("customerName"), false);
			memberships.add(mems);
		}
		
		return memberships;
		
	}

	@Override
	public void addMemberships(Memberships mems) throws IOException, SQLException {	
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "insert into memberships (memid, memprice, memname, memlength, memexception) values (?, ?, ?, ?, ?); ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, mems.getMemId());
		ps.setInt(2, mems.getMemprice());
		ps.setString(3, mems.getMemname());
		ps.setString(4, mems.getMemlength());
		ps.setString(5, mems.getMemexceptions());
		ps.executeUpdate();
	}

	@Override
	public void removeMembership(int memId) throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "delete from offers where memid = ?; delete from memberships where memid = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, memId);
		ps.setInt(2, memId);
		ps.executeUpdate();
		
		
	}

	@Override
	public ArrayList<MemberOffers> customerOffers() throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from offers where offeraccepted = false";
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<MemberOffers> offers = new ArrayList<MemberOffers>();
		while(rs.next()) {
			MemberOffers mo = new MemberOffers(rs.getInt("offerid"), rs.getInt("userid"), rs.getInt("memid"), rs.getInt("offer"), rs.getBoolean("offeraccepted"), rs.getBoolean("userpaid") );
			offers.add(mo);
		}
		return offers;
		
	}

	@Override
	public void acceptRejectOffer(int offerId, boolean accept, int memId) throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "update offers set offeraccepted = ? where offerid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, offerId);
		ps.setBoolean(2, accept);
		ps.executeUpdate();
		if(accept) {
			String sqlyes = "delete from offers where memid = ? and offeraccepted = ?";
			PreparedStatement psyes = con.prepareStatement(sqlyes);
			psyes.setInt(1, memId);
			psyes.setBoolean(2, false);
			psyes.executeUpdate();
		}
		
	}

	@Override
	public ArrayList<PaymentPortalEmployeeView> viewMemberPayments() throws IOException, SQLException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from payments p join users u on p.customername = u.uname;" ;
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery(sql);
		ArrayList<PaymentPortalEmployeeView> memberships = new ArrayList<PaymentPortalEmployeeView>();
		while(rs.next()) {
			PaymentPortalEmployeeView mems = new PaymentPortalEmployeeView(rs.getInt("payId"), rs.getString("memName"), rs.getString("customerName"), rs.getBoolean("userPaid"), rs.getInt("id"), rs.getString("username"), rs.getString("pword"), rs.getString("uname"), rs.getString("urole"));
			memberships.add(mems);
		}
		
		return memberships;
		
	}
	
	@Override
	public ArrayList<MemberOffers> getWeeklyPayments() throws SQLException, IOException {
		con = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM OFFERS where userPaid = 'true'"
				+ " and date_created > DATE(NOW()) - INTERVAL '7' DAY ;" ;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<MemberOffers> memberoffers = new ArrayList<MemberOffers>();
		while ( rs.next() ) {		
			MemberOffers mo = new MemberOffers(rs.getInt("offerid"), rs.getInt("userid"),
					rs.getInt("memid"), rs.getInt("offer"), rs.getBoolean("acceptOffer"),
					rs.getBoolean("userPaid"));
			memberoffers.add(mo);			
		}
		return memberoffers;
	}
	

}
