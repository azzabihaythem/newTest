package com.haythem.persistance;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "facture", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "year","month", "USER_ID" })})
public class Facture extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "User_ID")
	private User user;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "bordereau")
	Bordereau borderauNumber;

	
	@ManyToOne(optional = true)
	@JoinColumn(name = "seanceType")
	private Type seanceType; 

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	@Column(name = "month")
	String month;
	
	@Column(name = "year")
	String year;
	
	
	@Column
	String FactureNumber;
	
	@Column
	Long SeanceNumber;







	public Bordereau getBorderauNumber() {
		return borderauNumber;
	}

	public void setBorderauNumber(Bordereau borderauNumber) {
		this.borderauNumber = borderauNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getSeanceType() {
		return seanceType;
	}

	public void setSeanceType(Type seanceType) {
		this.seanceType = seanceType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getFactureNumber() {
		return FactureNumber;
	}

	public void setFactureNumber(String factureNumber) {
		FactureNumber = factureNumber;
	}

	public Long getSeanceNumber() {
		return SeanceNumber;
	}

	public void setSeanceNumber(Long seanceNumber) {
		SeanceNumber = seanceNumber;
	}
	
	

	
	
	

}
