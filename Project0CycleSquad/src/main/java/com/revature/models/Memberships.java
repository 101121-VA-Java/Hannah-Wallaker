package com.revature.models;

public class Memberships {
	
	private int memId;
	private int memprice;
	private String memname;
	private String memlength;
	private String memexceptions;
	
	
	public Memberships(int memId, int memprice, String memname, String memlength, String memexceptions) {
		super();
		this.memId = memId;
		this.memprice = memprice;
		this.memname = memname;
		this.memlength = memlength;
		this.memexceptions = memexceptions;
	}


	public int getMemId() {
		return memId;
	}


	public void setMemId(int memId) {
		this.memId = memId;
	}


	public int getMemprice() {
		return memprice;
	}


	public void setMemprice(int memprice) {
		this.memprice = memprice;
	}


	public String getMemname() {
		return memname;
	}


	public void setMemname(String memname) {
		this.memname = memname;
	}


	public String getMemlength() {
		return memlength;
	}


	public void setMemlength(String memlength) {
		this.memlength = memlength;
	}


	public String getMemexceptions() {
		return memexceptions;
	}


	public void setMemexceptions(String memexceptions) {
		this.memexceptions = memexceptions;
	}


	@Override
	public String toString() {
		return "Memberships [memId=" + memId + ", memprice=" + memprice + ", memname=" + memname + ", memlength="
				+ memlength + ", memexceptions=" + memexceptions + "]";
	}

	
}
