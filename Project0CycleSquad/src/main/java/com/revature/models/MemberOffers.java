package com.revature.models;

public class MemberOffers {
	
	private int offerId;
	private int userId;
	private int memId;
	private int offer;
	private boolean acceptOffer;
	private boolean userPaid;
	
	
	public MemberOffers(int offerId, int userId, int memId, int offer, boolean acceptOffer, boolean userPaid) {
		super();
		this.offerId = offerId;
		this.userId = userId;
		this.memId = memId;
		this.offer = offer;
		this.acceptOffer = acceptOffer;
		this.userPaid = userPaid;
	}


	public int getOfferId() {
		return offerId;
	}


	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMemId() {
		return memId;
	}


	public void setMemId(int memId) {
		this.memId = memId;
	}


	public int getOffer() {
		return offer;
	}


	public void setOffer(int offer) {
		this.offer = offer;
	}


	public boolean isAcceptOffer() {
		return acceptOffer;
	}


	public void setAcceptOffer(boolean acceptOffer) {
		this.acceptOffer = acceptOffer;
	}


	public boolean isUserPaid() {
		return userPaid;
	}


	public void setUserPaid(boolean userPaid) {
		this.userPaid = userPaid;
	}


	@Override
	public String toString() {
		return "MemberOffers [offerId=" + offerId + ", userId=" + userId + ", memId=" + memId + ", offer=" + offer
				+ ", acceptOffer=" + acceptOffer + ", userPaid=" + userPaid + "]";
	}
	
	

}
