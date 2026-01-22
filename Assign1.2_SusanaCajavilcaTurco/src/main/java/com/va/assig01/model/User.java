package com.va.assig01.model;

public class User {
	
	// I added the following criteria to the attributes of the model
	// 1 - address has a limit of 30 characters
	// 2 - zipCode must be exactly of 6 characters
	// 3 - about has a limit of 50 characters
	
	private String userId;  // required and must be of length from 5 to 12 characters
	private String password;  // required and must be of length from 7 to 12 characters
	private String name;  // required and must be made of alphabet character only
	private String address;  // optional. Max length of 30 characters
	private String country;  // required and must select a country from a select list 
	private String zipCode;  // required and must be numeric only. Must be 6 digits
	private String email;  // required and must be a valid email
	private String sex;  // required and must be only one of 2 radio buttons: Male , Female
	private String language;  // required and you can select 1 or 2 checkbox: English, Non-English
	private String about;  // optional. Max length of 50 characters
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getAbout() {
		return about;
	}
	
	public void setAbout(String about) {
		this.about = about;
	}

   
}
