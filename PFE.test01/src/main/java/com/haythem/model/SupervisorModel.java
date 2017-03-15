package com.haythem.model;


public class SupervisorModel {

	
	private String user;
	private String patient;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public SupervisorModel(String user, String patient) {
		this.user = user;
		this.patient = patient;
	}
	public SupervisorModel() {
	}
	
	
}
