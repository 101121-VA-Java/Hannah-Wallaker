package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ManagerDao {
	
	Reimbursements viewAllPending();
	boolean updateRequest(Reimbursements re);
	Reimbursements viewAllResolved();
	Reimbursements viewSpecificRequest();
	User viewAllEmployees() throws IOException, SQLException;
	
	

}
