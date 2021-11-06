package com.revature.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.MemberOffers;
import com.revature.models.Memberships;
import com.revature.models.PaymentPortal;
import com.revature.repositories.MembershipsDaoInt;
import com.revature.repositories.MembershipsPostgres;

public class MembershipsServices {
	
	private MembershipsPostgres mp;
	
	public MembershipsServices() {
		mp = new MembershipsPostgres();
	}
	
	public void addMemberships(Memberships mems) {
		try {
			mp.addMembership(mems);
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public ArrayList<Memberships> viewMyMemberships(int userId){
		try {
			displayListMemberships(mp.viewMyMemberships(userId));
		}catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<MemberOffers> customerOffers(){
		try {
			displayListMemberOffers(mp.viewPendingOffers());
			return mp.viewPendingOffers();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
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
