package com.haythem.persistance;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "patientdetails")
public class PatientDetails extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID")
	private User user;

	

	
	



	@Column(name = "DOIT")
	private String DOIT; 
	
	@Column(name = "AFFILE")
	private String affile; 
	
	@Column(name = "NUMAFFLICALTION")
	private String numAffilation; 
	
	@Column(name = "Num_PRISE_EN_CHARGE")
	private String numPriseEnCharge; 
	
	@Column(name = "DATED_PRISE_EN_CHARGE")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateDebut;
	
	
	@Column(name = "DATEF_PRISE_EN_CHARGE")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateFin;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getDOIT() {
		return DOIT;
	}


	public void setDOIT(String dOIT) {
		DOIT = dOIT;
	}


	public String getAffile() {
		return affile;
	}


	public void setAffile(String affile) {
		this.affile = affile;
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

	

	
	

}
