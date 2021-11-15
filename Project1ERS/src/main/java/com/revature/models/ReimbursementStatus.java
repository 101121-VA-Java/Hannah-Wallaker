package com.revature.models;

public class ReimbursementStatus {
	
	private int statusId;
	private String Status;
	
	
	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		Status = status;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", Status=" + Status + "]";
	}

}
