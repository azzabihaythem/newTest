package com.haythem.persistance;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

//@Table(name = "user" , uniqueConstraints = @UniqueConstraint(columnNames = {
//		"USER_NAME", "CIN_USER"}))


@Entity
@Table(name = "userorganization")
public class UserOrganization extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManyToOne(optional = true)
	@JoinColumn(name = "USER_ID", unique = true)
	private User user;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "OrganizationId")
	private Organization organization;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	
	
	



	
}
