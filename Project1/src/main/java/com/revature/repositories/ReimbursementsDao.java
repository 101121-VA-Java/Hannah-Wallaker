package com.revature.repositories;

import com.revature.models.Reimbursements;
import com.revature.models.Users;

public interface ReimbursementsDao {


	
	//employees can submit reimbursement requests, upload receipts**,  view pending requests
	//view resolved requests, receive email when request is resolved**
	boolean submitMyRequest (Reimbursements r);
	boolean submitMyReceipt (Reimbursements r);
	Reimbursements viewMyPending(Users u);
	Reimbursements viewMyResolved(Users u);
	
	
	//managers can approve/deny requests, view all pending requests, view receipt images**, 
	//view all resolved requests and who resolved it, view requests per employee
	boolean approveDeny (Reimbursements r);
	Reimbursements viewAllPending();
	Reimbursements viewReceipt(Reimbursements r);
	Reimbursements viewAllResolved();
	Reimbursements viewRequestsByEmp(Users u);
	
	
}
