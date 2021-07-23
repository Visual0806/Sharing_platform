package com.entity;

public class Student {
	private String Sname; 
	private int Sno; 
	private int Scno; 
	private String Saddr; 
	private String Sphone;
	public Student(String sname, int sno, int scno, String saddr, String sphone) {
		super();
		Sname = sname;
		Sno = sno;
		Scno = scno;
		Saddr = saddr;
		Sphone = sphone;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public int getScno() {
		return Scno;
	}
	public void setScno(int scno) {
		Scno = scno;
	}
	public String getSaddr() {
		return Saddr;
	}
	public void setSaddr(String saddr) {
		Saddr = saddr;
	}
	public String getSphone() {
		return Sphone;
	}
	public void setSphone(String sphone) {
		Sphone = sphone;
	}
	
}
