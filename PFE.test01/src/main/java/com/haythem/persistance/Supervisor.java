package com.haythem.persistance;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name="supervisor")
public class Supervisor extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Column
//	private String function;
//	
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;


	


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Supervisor(Patient patient,User user) {
		
		this.user = user;
		this.patient = patient;
	}


	public Supervisor() {
	}
	
	


	
	
	
	

}
