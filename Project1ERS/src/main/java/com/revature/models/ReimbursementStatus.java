package com.revature.models;

public class ReimbursementStatus {
	
	private int statusId;
	private boolean reApproved;
	
	
	public ReimbursementStatus(int statusId, boolean reApproved) {
		super();
		this.statusId = statusId;
		this.reApproved = reApproved;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public boolean isReApproved() {
		return reApproved;
	}
	public void setReApproved(boolean reApproved) {
		this.reApproved = reApproved;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", reApproved=" + reApproved + "]";
	}
	
}

