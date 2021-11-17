package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;

public class EmployeeServices {
	
	private EmployeeDao ed;
	
	EmployeeServices(){
		super();
		ed = new EmployeePostgres();
	}
	
	
	public boolean submitMyRequest(Reimbursements re) {
		if(ed.submitMyRequest(re)) {
			return true;
		}
		return false;
	}
	
	public void viewMyPending(User u) {
		ArrayList<Reimbursements> reList = ed.viewMyPending(u);
	}
	
	public void viewMyResolved(User u) {
		ArrayList<Reimbursements> relist = ed.viewMyResolved(u);
	}
	

}
