package com.revature.models;

public class Reimbursements {
	
	private int reimbursementId;
	private double amount;
	private boolean submitted;
	private boolean resolved;
	private String description;
	private String receipt;
	private Users creator;
	private Users resolver;
	private ReimbursementStatus status;
	private ReimbursementType type;
	
	public Reimbursements(int reimbursementId, double amount, boolean submitted, boolean resolved, String description,
			String receipt, Users creator, Users resolver, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.creator = creator;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Users getCreator() {
		return creator;
	}

	public void setCreator(Users creator) {
		this.creator = creator;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", receipt=" + receipt + ", creator="
				+ creator + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}
	
	

}
