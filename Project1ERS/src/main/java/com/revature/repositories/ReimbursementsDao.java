package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.ReimbursementStatus;
import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ReimbursementsDao {
	
	// employees can submit reimbursement requests, view their pending requests,
	//and view their resolved requests
	
	boolean submitMyRequest (Reimbursements re);
	ArrayList<Reimbursements> viewMyPending(User u);
	ArrayList<Reimbursements> viewMyResolved(User u);
	
	
	
	//managers can view all pending, approve/deny requests, view resolved requests and who resolved them,
	//view request by employee 
	
	ArrayList<Reimbursements> viewAllPending();
	ArrayList<ReimbursementStatus> viewAllResolved();
	ArrayList<Reimbursements> viewSpecificResolved(User u) throws IOException, SQLException;
	boolean approveDeny(Reimbursements re);
	
	
}
