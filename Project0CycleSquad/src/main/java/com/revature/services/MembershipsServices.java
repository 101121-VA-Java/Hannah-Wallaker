package com.revature.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.models.User;
import com.revature.repositories.MembershipsDaoInt;
import com.revature.repositories.MembershipsPostgres;

public class MembershipsServices {
	
	private MembershipsPostgres mp;
	
	public MembershipsServices() {
		mp = new MembershipsPostgres();
	}
	
	public boolean addMemberships(Memberships mems) {
		try {
			mp.addMembership(mems);
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
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
			System.out.println("Sorry, offer did not go through");
		}catch(IOException e) {
			System.out.println("Sorry, offer unsuccessful");
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
	
	public ArrayList<PaymentPortal> viewMemberPayments(){
		try {
			displayListPaymentPortal(mp.viewMemberPayments());
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
	
	
	
	
	
	
	
}
