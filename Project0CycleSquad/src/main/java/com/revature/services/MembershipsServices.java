package com.revature.services;

import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.models.PaymentPortalEmployeeView;
import com.revature.models.User;
import com.revature.repositories.MembershipsDaoInt;
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
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Memberships> getAllMemberships(){
		try {
			return mp.viewAllMemberships();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<PaymentPortal> viewMyMemberships(int userId){
		try {
			displayListPaymentPortal(mp.viewMyMemberships(userId));
		}catch(SQLException e) {
		//	log.("payment portal error", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<MemberOffers> customerOffers(){
		try {
			displayListMemberOffers(mp.customerOffers());
			return mp.customerOffers();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void makeMyOffer(User u, int memid, int memprice) {
		try {
			mp.makeMyOffer(u, memid, memprice);
			System.out.println("Offer success! Awaiting review");
		}
		catch(SQLException e){
		//	Log.error("Sorry, offer did not go through", e);
		}catch(IOException e) {
		//	Log.error("Sorry, offer unsuccessful", e);
		}
	}
	
	public void acceptRejectOffer(int offerId, boolean accept, int memId) {
		try {
			mp.acceptRejectOffer(offerId, accept, memId);
			System.out.println("A team member has reviewed this offer!");
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void calculateWeeklyPayment() {
		try {
			showWeeklyPayment(mp.getWeeklyPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
		//	Log.error("Fatal error while trying to calculate Weekly Payment.", e);
			e.printStackTrace();
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
