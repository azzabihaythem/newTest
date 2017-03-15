package com.haythem.persistance;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "organization")
public class Organization extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
	
	
	
	public String getNameOrganization() {
		return nameOrganization;
	}







	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}







	@Column(name = "NameOrganization")
	private String nameOrganization; 

	

	
	

}
