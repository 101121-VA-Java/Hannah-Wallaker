package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.models.PaymentPortalEmployeeView;
import com.revature.models.User;
import com.revature.repositories.MembershipsPostgres;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MembershipsServices {
	private static Logger log = LogManager.getRootLogger();
	private MembershipsPostgres mp;
	
	public MembershipsServices() {
		mp = new MembershipsPostgres();
	}
	
	public boolean addMemberships(Memberships mems) {
		try {
			mp.addMemberships(mems);
		} catch (SQLException e) {
			log.error("Warning: something went wrong trying to add an item");

		} catch (IOException e) {
			log.error("Warning: something went wrong trying to add an item");
		}
		
		return true;
	}
	
	public void removeMemberships(int memId) {
		try {
			mp.removeMembership(memId);
		}catch(SQLException e) {
			log.error("Warning: error trying  to remove item");
		} catch (IOException e) {
			log.error("Warning: error trying  to remove item");
		}
	}
	
	public ArrayList<Memberships> getAllMemberships(){
		try {
			return mp.viewAllMemberships();
			
		}catch (SQLException e) {
			log.error("Warning: error retrieving all memberships");
			
		} catch (IOException e) {
			log.error("Warning: error retrieving all memberships");
		}
		
		return null;
	}
	
	public ArrayList<PaymentPortal> viewMyMemberships(int userId){
		try {
			displayListPaymentPortal(mp.viewMyMemberships(userId));
		}catch(SQLException e) {
			log.error("Warning: error when customer is trying to view all memberships");
		} catch (IOException e) {
			log.error("Warning: error when customer is trying to view all memberships");
		}
		
		return null;
	}
	
	public ArrayList<MemberOffers> customerOffers(){
		try {
			displayListMemberOffers(mp.customerOffers());
			return mp.customerOffers();
		}catch(SQLException e) {
			log.error("error when employee tries viewing customer offers");
		}catch (IOException e) {
			log.error("error when employee tries viewing customer offers");
		}
		
		return null;
	}
	
	public void makeMyOffer(User u, int memid, int memprice) {
		try {
			mp.makeMyOffer(u, memid, memprice);
			System.out.println("Offer success! Awaiting review");
		}
		catch(SQLException e){
			log.info("member should send offer to system for us to accept or reject on employee end");
		}catch(IOException e) {
			log.info("member should send offer to system for us to accept or reject on employee end");
		}
	}
	
	public void acceptRejectOffer(int offerId, boolean accept, int memId) {
		try {
			mp.acceptRejectOffer(offerId, accept, memId);
			System.out.println("A team member has reviewed this offer!");
		}catch(SQLException e) {
			log.info("sccept or reject offer should persist to database");
		} catch (IOException e) {
			log.info("sccept or reject offer should persist to database");
		}
	}
	
	public ArrayList<Memberships> viewMyPendingPurchases(){
		try {
			displayListMemberships(mp.viewMyPendingPurchases());
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<PaymentPortal> viewMyPayments(int userId){
		try {
			displayListPaymentPortal(mp.viewMyPayments(userId));
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<PaymentPortalEmployeeView> viewMemberPayments(){
		try {
			displayListPaymentPortalEmployeeView(mp.viewMemberPayments());
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void calculateWeeklyPayment() {
		try {
			showWeeklyPayment(mp.getWeeklyPayments());
		} catch (SQLException | IOException e) {
			log.error("error calculating and displaying weekly payments");
		}
	}
	
	
	
		
	private void showWeeklyPayment(ArrayList<PaymentPortal> weeklyPayments) {
		int sales = 0;
		for(PaymentPortal pp : weeklyPayments) {
			sales += pp.getPayId();
		}
		System.out.println("Total for week is:" + sales);
		
	}

	public void displayListMemberships(ArrayList<Memberships> list) {
		for (Memberships mems : list) {
			System.out.println(mems);
	}
	}
		
	public void displayListPaymentPortal(ArrayList<PaymentPortal> list) {
		for(PaymentPortal mems : list) {
			System.out.println(mems);
		}
	}
	
	public void displayListMemberOffers(ArrayList<MemberOffers> list) {
		for(MemberOffers mems :list) {
			System.out.println(mems);
		}
}
	
	
	
	public void displayListPaymentPortalEmployeeView(ArrayList<PaymentPortalEmployeeView> list) {
		for(PaymentPortalEmployeeView mems : list) {
			System.out.println(mems);
		}
	}
	
	
	
}
