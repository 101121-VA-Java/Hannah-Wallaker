package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.models.PaymentPortalEmployeeView;
import com.revature.models.User;

public interface MembershipsDaoInt {
	
	//Customer:
	
	ArrayList<Memberships> viewAllMemberships() throws IOException, SQLException;
	
	ArrayList<PaymentPortal> viewMyMemberships(int userId) throws IOException, SQLException;
	
	ArrayList<Memberships> viewMyPendingPurchases() throws IOException, SQLException;
	
	void makeMyOffer(User u, int memid, int price) throws IOException, SQLException;
	
	ArrayList<PaymentPortal> viewMyPayments(int userId) throws IOException, SQLException;
	
	
	
	
	//employee:
	void addMemberships(Memberships mem) throws IOException, SQLException;
	
	void removeMembership(int memId) throws IOException, SQLException;
	
	ArrayList<MemberOffers> customerOffers() throws IOException, SQLException;
	
	void acceptRejectOffer(int offerId, boolean accept , int memid) throws IOException, SQLException;
	
	ArrayList<PaymentPortalEmployeeView> viewMemberPayments() throws IOException, SQLException;
	

	ArrayList<MemberOffers> getWeeklyPayments() throws SQLException, IOException;
}
