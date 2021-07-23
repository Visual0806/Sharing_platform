package com.entity;

import java.util.Date;

public class User {
	private String userID;
	private String userPassword;
	private boolean userType;
	private Date registerTime;
	
	public User(String userID, String userPassword, boolean userType, Date registerTime) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userType = userType;
		this.registerTime = registerTime;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserType() {
		return userType;
	}
	public void setUserType(boolean userType) {
		this.userType = userType;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
}