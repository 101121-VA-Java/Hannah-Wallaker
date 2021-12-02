package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.ManagerDao;
import com.revature.repositories.ManagerPostgres;

public class ManagerServices {
	
	ManagerDao md = new ManagerPostgres();
	

	public ArrayList<Reimbursements> viewAllPending(){
		return md.viewAllPending();

	}
	
	public boolean updateRequest(int statusid) {
		if(md.updateRequest(statusid)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Reimbursements> viewAllResolved(){
		return md.viewAllResolved();
	}
	
	public ArrayList<Reimbursements> viewSpecificRequest(String username) {
		return md.viewSpecificRequest(username);
		
	}
	ArrayList<User> viewAllEmployees(){
		return md.viewAllEmployees();
	} 
	
	ArrayList<Reimbursements> viewAll(){
		return md.viewAllReimbursements();
	}
	

}
