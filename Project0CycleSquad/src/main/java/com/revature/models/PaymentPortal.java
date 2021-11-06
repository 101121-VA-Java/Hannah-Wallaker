package com.revature.models;

public class PaymentPortal {
	
	private int memId;
	private int memPrice;
	private String memName;
	private String memLength;
	private String memExceptions;
	private Boolean userPaid;
	
	
	public PaymentPortal(int memId, int memPrice, String memName, String memLength, String memExceptions,
			Boolean userPaid) {
		super();
		this.memId = memId;
		this.memPrice = memPrice;
		this.memName = memName;
		this.memLength = memLength;
		this.memExceptions = memExceptions;
		this.userPaid = userPaid;
	}


	public int getMemId() {
		return memId;
	}


	public void setMemId(int memId) {
		this.memId = memId;
	}


	public int getMemPrice() {
		return memPrice;
	}


	public void setMemPrice(int memPrice) {
		this.memPrice = memPrice;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemLength() {
		return memLength;
	}


	public void setMemLength(String memLength) {
		this.memLength = memLength;
	}


	public String getMemExceptions() {
		return memExceptions;
	}


	public void setMemExceptions(String memExceptions) {
		this.memExceptions = memExceptions;
	}


	public Boolean getUserPaid() {
		return userPaid;
	}


	public void setUserPaid(Boolean userPaid) {
		this.userPaid = userPaid;
	}


	@Override
	public String toString() {
		return "PaymentPortal [memId=" + memId + ", memPrice=" + memPrice + ", memName=" + memName + ", memLength="
				+ memLength + ", memExceptions=" + memExceptions + ", userPaid=" + userPaid + "]";
	}
	
	
	
}