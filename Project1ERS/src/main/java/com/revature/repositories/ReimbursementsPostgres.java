package com.revature.repositories;

import com.revature.models.Reimbursements;
import com.revature.models.User;

public class ReimbursementsPostgres implements ReimbursementsDao {

	@Override
	public boolean submitMyRequest(Reimbursements re) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursements viewMyPending(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements viewMyResolved(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements viewAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements viewAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements viewSpecificResolved(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveDeny(Reimbursements re) {
		// TODO Auto-generated method stub
		return false;
	}

}
