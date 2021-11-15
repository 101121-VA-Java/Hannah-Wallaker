package com.revature.repositories;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ReimbursementsDao {
	
	// employees can submit reimbursement requests, view their pending requests,
	//and view their resolved requests
	
	boolean submitMyRequest (Reimbursements re);
	Reimbursements viewMyPending(User u);
	Reimbursements viewMyResolved(User u);

	
	//managers can view all pending, approve/deny requests, view resolved requests and who resolved them,
	//view request by employee 
	
	Reimbursements viewAllPending();
	Reimbursements viewAllResolved();
	Reimbursements viewSpecificResolved(User u);
	boolean approveDeny(Reimbursements re);
	
	
}
