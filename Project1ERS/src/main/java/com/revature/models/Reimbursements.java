package com.revature.models;

public class Reimbursements {
	
	private int reId;
	private double reAmount;
	private boolean reSubmitted;
	private boolean reResolved;
	private String reDescription;
	private User reCreator;
	private User reResolver;
	private ReimbursementStatus reStatus;
	private ReimbursementType reType;
	public Reimbursements(int reId, double reAmount, boolean reSubmitted, boolean reResolved, String reDescription,
			User reCreator, User reResolver, ReimbursementStatus reStatus, ReimbursementType reType) {
		super();
		this.reId = reId;
		this.reAmount = reAmount;
		this.reSubmitted = reSubmitted;
		this.reResolved = reResolved;
		this.reDescription = reDescription;
		this.reCreator = reCreator;
		this.reResolver = reResolver;
		this.reStatus = reStatus;
		this.reType = reType;
	}
	public Reimbursements(int int1, String string, double double1, String string2, int int2, int int3) {
		// TODO Auto-generated constructor stub
	}
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public double getReAmount() {
		return reAmount;
	}
	public void setReAmount(double reAmount) {
		this.reAmount = reAmount;
	}
	public boolean isReSubmitted() {
		return reSubmitted;
	}
	public void setReSubmitted(boolean reSubmitted) {
		this.reSubmitted = reSubmitted;
	}
	public boolean isReResolved() {
		return reResolved;
	}
	public void setReResolved(boolean reResolved) {
		this.reResolved = reResolved;
	}
	public String getReDescription() {
		return reDescription;
	}
	public void setReDescription(String reDescription) {
		this.reDescription = reDescription;
	}
	public User getReCreator() {
		return reCreator;
	}
	public void setReCreator(User reCreator) {
		this.reCreator = reCreator;
	}
	public User getReResolver() {
		return reResolver;
	}
	public void setReResolver(User reResolver) {
		this.reResolver = reResolver;
	}
	public ReimbursementStatus getReStatus() {
		return reStatus;
	}
	public void setReStatus(ReimbursementStatus reStatus) {
		this.reStatus = reStatus;
	}
	public ReimbursementType getReType() {
		return reType;
	}
	public void setReType(ReimbursementType reType) {
		this.reType = reType;
	}
	@Override
	public String toString() {
		return "Reimbursements [reId=" + reId + ", reAmount=" + reAmount + ", reSubmitted=" + reSubmitted
				+ ", reResolved=" + reResolved + ", reDescription=" + reDescription + ", reCreator=" + reCreator
				+ ", reResolver=" + reResolver + ", reStatus=" + reStatus + ", reType=" + reType + "]";
	}

	
}
