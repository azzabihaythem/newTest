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
@Table(name = "seance", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ID","month","year","DATE"})})
public class Seance extends AbstractPersistable<Long> implements Comparable<Seance> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "facture")
	private Facture facture;

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	@Column(name = "month")
	String month;
	
	@Column(name = "year")
	String year;

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "Type")
	private Type type; 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int compareTo(Seance o) {
		return getDate().compareTo(o.getDate());
		
	}

	

	
	

}
