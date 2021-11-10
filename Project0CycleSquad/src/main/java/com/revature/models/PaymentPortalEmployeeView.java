package com.revature.models;

public class PaymentPortalEmployeeView {
	
	private int payId;
	private String memName;
	private String customerName;
	private boolean userPaid;
	private String datePaid;
	private int id;
	private String username;
	private String pword;
	private String uname;
	private String urole;
	
	public PaymentPortalEmployeeView(int payId, String memName, String customerName, boolean userPaid, String datePaid, int id,
			String username, String pword, String uname, String urole) {
		super();
		this.payId = payId;
		this.memName = memName;
		this.customerName = customerName;
		this.userPaid = userPaid;
		this.datePaid = datePaid;
		this.id = id;
		this.username = username;
		this.pword = pword;
		this.uname = uname;
		this.urole = urole;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

	@Override
	public String toString() {
		return "PaymentPortalEmployeeView [payId=" + payId + ", memName=" + memName + ", customerName=" + customerName
				+ ", userPaid=" + userPaid + ", datePaid=" + datePaid + ", id=" + id + ", username=" + username + ", pword=" + pword + ", uname="
				+ uname + ", urole=" + urole + "]";
	}

	public String getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}
	
	
	

}
