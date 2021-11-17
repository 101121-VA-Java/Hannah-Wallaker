package com.revature.repositories;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ManagerDao {
	
	Reimbursements viewAllPending();
	boolean updateRequest(Reimbursements re);
	Reimbursements viewAllResolved();
	Reimbursements viewSpecificRequest();
	User viewAllEmployees();
	
	

}
