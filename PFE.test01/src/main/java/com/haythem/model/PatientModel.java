package com.haythem.model;


public class PatientModel {

	
	private WatchModel watch;
	private String hbRef;//heartbit reference
	private String SRef;//heartbit reference
	private UserModel user;
	public WatchModel getWatch() {
		return watch;
	}
	public void setWatch(WatchModel watch) {
		this.watch = watch;
	}
	public String getHbRef() {
		return hbRef;
	}
	public void setHbRef(String hbRef) {
		this.hbRef = hbRef;
	}
	public String getSRef() {
		return SRef;
	}
	public void setSRef(String sRef) {
		this.SRef = sRef;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public PatientModel(WatchModel watch, String hbRef, String sRef, UserModel user) {
		this.watch = watch;
		this.hbRef = hbRef;
		this.SRef = sRef;
		this.user = user;
	}
	public PatientModel() {
		
	}
	
	
	
	
}
