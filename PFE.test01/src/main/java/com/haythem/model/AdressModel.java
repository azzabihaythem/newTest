package com.haythem.model;



public class AdressModel {

	
	
	private String country; 
	private String state;
	private String adress;
	
	
	
	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public AdressModel(String country, String state, String adress) {
	
		this.country = country;
		this.state = state;
		this.adress = adress;
	}



	public AdressModel() {
		
	}
	
	
	
}
