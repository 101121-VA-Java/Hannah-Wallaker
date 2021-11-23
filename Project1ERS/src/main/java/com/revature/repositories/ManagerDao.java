package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public interface ManagerDao {
	
	ArrayList<Reimbursements> viewAllPending();
	boolean updateRequest(Reimbursements re);
	ArrayList<Reimbursements> viewAllResolved();
	Reimbursements viewSpecificRequest();
	ArrayList<User> viewAllEmployees();
	
	

}
