package com.revature.models;

public class PaymentPortal {
	
	private int payId;
	private String memName;
	private String customerName;
	private boolean userPaid;
	private String datePaid;
	
	public PaymentPortal(int payId, String memName, String customerName, boolean userPaid, String datePaid) {
		super();
		this.payId = payId;
		this.memName = memName;
		this.customerName = customerName;
		this.userPaid = userPaid;
		this.setDatePaid(datePaid);
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isUserPaid() {
		return userPaid;
	}

	public void setUserPaid(boolean userPaid) {
		this.userPaid = userPaid;
	}

	@Override
	public String toString() {
		return "PaymentPortal [payId=" + payId + ", memName=" + memName + ", customerName=" + customerName
				+ ", userPaid=" + userPaid + ", datePaid=" + datePaid +"]";
	}

	public String getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}
	
	
	
	
}