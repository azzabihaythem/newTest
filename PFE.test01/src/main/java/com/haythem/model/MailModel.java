package com.haythem.model;

public class MailModel {

	
	
	private String to;
	private String object;
	private String body;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public MailModel(String to, String object, String body) {
		super();
		this.to = to;
		this.object = object;
		this.body = body;
	}
	public MailModel() {
		super();
	}
	
	
	
	
}
