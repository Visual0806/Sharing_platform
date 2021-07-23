package com.entity;

public class NUAA_USER {
	private String USER_ID;
	private String USER_PASSWORD;
	public NUAA_USER(String uSER_ID, String uSER_PASSWORD) {
		super();
		USER_ID = uSER_ID;
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	
	
}
