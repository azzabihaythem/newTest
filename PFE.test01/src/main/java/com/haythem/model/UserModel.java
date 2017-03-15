package com.haythem.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;




public class UserModel {

	private int role;
	private String id;
    @NotEmpty
    @Size(min=4,max=12)
	private String username;
    @NotEmpty
    @Size(min=4,max=12)
	private String password;
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserModel(int role, String id, String username, String password) {
		super();
		this.role = role;
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public UserModel() {
		
	}
	
	
	
}
