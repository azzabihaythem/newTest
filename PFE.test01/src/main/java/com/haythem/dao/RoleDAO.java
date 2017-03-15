package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Role;

public interface RoleDAO extends JpaRepository<Role, Long>{
	
	//public Role getRole(int id);
	Role findByRole(String role);

}
