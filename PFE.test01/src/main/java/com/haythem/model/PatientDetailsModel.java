package com.haythem.model;

import java.util.Date;


public class PatientDetailsModel {

	
	private String  firstname;
	private String lastname;
	private String type;
	private String DOIT; 
	private String affile; 
	private String numAffilation; 
	private String numPriseEnCharge; 
	private Date dateDebut;
	private Date dateFin;
	
	

	public String getFirstname() {
		return firstname;
	}



	public String getAffile() {
		return affile;
	}



	public void setAffile(String affile) {
		this.affile = affile;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDOIT() {
		return DOIT;
	}



	public void setDOIT(String dOIT) {
		DOIT = dOIT;
	}



	public String getNumAffilation() {
		return numAffilation;
	}



	public void setNumAffilation(String numAffilation) {
		this.numAffilation = numAffilation;
	}



	public String getNumPriseEnCharge() {
		return numPriseEnCharge;
	}



	public void setNumPriseEnCharge(String numPriseEnCharge) {
		this.numPriseEnCharge = numPriseEnCharge;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public PatientDetailsModel() {
		
	}
	
	
	
	
}
