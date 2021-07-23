package com.entity;

public class Class {
	private int Cno; 
	private String Cteacher; 
	private String Cdept; 
	private int Cnum;
	public Class(int cno, String cteacher, String cdept, int cnum) {
		super();
		Cno = cno;
		Cteacher = cteacher;
		Cdept = cdept;
		Cnum = cnum;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}
	public String getCteacher() {
		return Cteacher;
	}
	public void setCteacher(String cteacher) {
		Cteacher = cteacher;
	}
	public String getCdept() {
		return Cdept;
	}
	public void setCdept(String cdept) {
		Cdept = cdept;
	}
	public int getCnum() {
		return Cnum;
	}
	public void setCnum(int cnum) {
		Cnum = cnum;
	}
	
	
	
}
