package com.entity;

import java.util.Date;

public class Document {
	private String docID;
	private String userID;
	private String title;
	private String content;
	private String tag;
	private Date publishTime;
	private int auditResult;
	
	public Document(String docID, String userID, String title, String content, String tag, Date publishTime,
			int auditResult) {
		super();
		this.docID = docID;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.publishTime = publishTime;
		this.auditResult = auditResult;
	}
	
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public int getAuditResult() {
		return auditResult;
	}
	public void setAuditResult(int auditResult) {
		this.auditResult = auditResult;
	}
	
}
