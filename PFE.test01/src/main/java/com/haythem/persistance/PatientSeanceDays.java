package com.haythem.persistance;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "patient_seance_days", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ID","Day"})})
public class PatientSeanceDays extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID")
	private User user;

	

	@Column(name = "Day")
	private String Day;



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getDay() {
		return Day;
	}



	public void setDay(String day) {
		Day = day;
	}



	public PatientSeanceDays(User user, String day) {
		super();
		this.user = user;
		Day = day;
	}



	public PatientSeanceDays() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

	
	

}
