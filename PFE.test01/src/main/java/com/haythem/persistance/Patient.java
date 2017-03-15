package com.haythem.persistance;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;

//import javax.persistence.UniqueConstraint;


//@Entity
//@Table(name = "patient", uniqueConstraints = {
//		@UniqueConstraint(columnNames = { "NOM_PATIENT", "CIN_PATIENT" }),
//		@UniqueConstraint(columnNames = {}) })

@Entity
@Table(name = "patient", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "WATCH_ID", "USER_ID" })})
public class Patient extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 8559110518875743028L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "WATCH_ID", unique = true)
	private Watch watch;
	
	@Column(name = "HB_REF")
	private String hbRef;//heartbit reference
	
	@Column(name = "S_REF")
	private String SRef;//heartbit reference
	

	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID", unique = true)
	private User user;


	public Watch getWatch() {
		return watch;
	}


	public void setWatch(Watch watch) {
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
		SRef = sRef;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Patient(Watch watch, String hbRef, String sRef, User user) {
		this.watch = watch;
		this.hbRef = hbRef;
		SRef = sRef;
		this.user = user;
	}


	public Patient() {
	}


	


}
