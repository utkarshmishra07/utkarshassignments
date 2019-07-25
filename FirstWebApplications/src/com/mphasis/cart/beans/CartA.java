package com.mphasis.cart.beans;

public class CartA {
	private int userid;
	private String username;
	private String password;
	private String emailid;
	private String dor;
	private long crcardno;
	private String gender;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public long getCrcardno() {
		return crcardno;
	}
	public void setCrcardno(long crcardno) {
		this.crcardno = crcardno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CartA [userid=" + userid + ", username=" + username + ", password=" + password + ", emailid=" + emailid
				+ ", dor=" + dor + ", crcardno=" + crcardno + ", gender=" + gender + "]";
	}
	public CartA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartA(int userid, String username, String password, String emailid, String dor, long crcardno, String gender) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.dor = dor;
		this.crcardno = crcardno;
		this.gender = gender;
	}
	

}
