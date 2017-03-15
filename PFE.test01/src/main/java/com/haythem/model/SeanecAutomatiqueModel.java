package com.haythem.model;

import java.util.Date;



public class SeanecAutomatiqueModel {

	
	private UserModel user;
	
	private String title;
	private String type;
	private String value;
	
	private Date date;
	private Date date2;
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SeanecAutomatiqueModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeanecAutomatiqueModel(UserModel user, String title, String type, String value,
			Date date, Date date2) {
		super();
		this.user = user;
		this.title = title;
		this.type = type;
		this.value = value;
		this.date = date;
		this.date2 = date2;
	}
	
	
}
