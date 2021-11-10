package com.revature.models;

public class User {
	
	public static User u;
	private int id;
	private String username;
	private String pword;
	private String uname;
	private Role urole;
	
	public User(String username, String pword, String uname, Role urole) {
		super();
		this.id = id;
		this.username = username;
		this.pword = pword;
		this.uname = uname;
		this.urole = urole;
	}

	public static User getU() {
		return u;
	}

	public static void setU(User u) {
		User.u = u;
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

	public Role getUrole() {
		return urole;
	}

	public void setUrole(Role urole) {
		this.urole = urole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pword=" + pword + ", uname=" + uname + ", urole="
				+ urole + "]";
	}
	
	
	
	
}