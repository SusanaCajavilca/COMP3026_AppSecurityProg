package com.sct.model;

public class HashedUser {
	
	private String username;   // required
	private String password;  // required and it will be hashed
	private String mobileNumber;  // required and must be a valid phone number
	private String emailId;  // required and must be a valid email
	
	
	// getters and setters generated quickly by selecting the attributes, right click> source> generate getters and setters> select all > Generate
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
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}
