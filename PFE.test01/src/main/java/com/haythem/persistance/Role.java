package com.haythem.persistance;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="roles")
public class Role extends AbstractPersistable<Long>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String role;
	
//
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="user_roles", 
//		joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
//		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
//	)
//	private Set<User> userRoles;

	

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Set<User> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(Set<User> userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public Role(String role, Set<User> userRoles) {
//		this.role = role;
//		this.userRoles = userRoles;
//	}

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	
	
	
	
}
