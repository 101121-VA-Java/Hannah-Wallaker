package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.CustomerOffers;
import com.revature.models.Memberships;
import com.revature.models.User;

public interface MembershipsDao {
	
	//Employee capabilities:
	
	//add memberships:
	void addMembership(Memberships m);
	
	//accept and reject customer offers:
	CustomerOffers[] getPendingOffers();
	boolean offerReview(int userId, int memId);
	
	//remove memberships:
	boolean removeMem(int memId);
	
	//view payments
	CustomerOffers[] getPayments();
	
	
	//Customer Capabilities:
	
	// see what memberships I can choose
	ArrayList<Memberships> viewMemberships();
	
	//make an offer:
	void makeOffer(User u, int memId, int price);

}
