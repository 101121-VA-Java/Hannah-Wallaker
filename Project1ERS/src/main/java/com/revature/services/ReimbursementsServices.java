package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.ReimbursementsDao;

public class ReimbursementsServices {
	
	private ReimbursementsDao rd;
	
	//employee
	public boolean submitMyRequest(Reimbursements re) {
		if(rd.submitMyRequest(re)) {
			return true;
		}
		return false;
	}
	
	public void viewMyPending(User u) {
		ArrayList<Reimbursements> reList = rd.viewMyPending(u);
	}
	
	public void viewMyResolved(User u) {
		ArrayList<Reimbursements> relist = rd.viewMyResolved(u);
	}
	
	
	//managers
	

}
