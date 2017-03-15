package com.haythem.persistance;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "bordereau", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "year","month"})})
public class Bordereau extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	@Column(name = "month")
	String month;
	
	@Column(name = "year")
	String year;
	
	
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	String BorderauNumber;


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


	public String getBorderauNumber() {
		return BorderauNumber;
	}


	public void setBorderauNumber(String borderauNumber) {
		BorderauNumber = borderauNumber;
	}
	
	






	
	

}
