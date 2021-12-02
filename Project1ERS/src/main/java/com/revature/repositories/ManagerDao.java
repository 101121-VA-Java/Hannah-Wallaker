package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ManagerDao {
	
	ArrayList<Reimbursements> viewAllPending();
	ArrayList<Reimbursements> viewAllResolved();
	ArrayList<User> viewAllEmployees();
	ArrayList<Reimbursements> viewSpecificRequest(String username);
	boolean updateRequest(int statusid);
	public ArrayList<Reimbursements> viewAllReimbursements();
	

}
