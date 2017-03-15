package com.haythem.persistance;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "banque")
public class Banque extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Column(name = "BanqueName")
	private String baqueName; 
	
	@Column(name = "Number")
	private String number;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "Organization")
	private Organization organization;
	

	public String getBaqueName() {
		return baqueName;
	}

	public void setBaqueName(String baqueName) {
		this.baqueName = baqueName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	} 

	
	
	
	

	
	

}
