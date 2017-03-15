package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Role;

public interface RoleService {
	
	public void save(Role user);
	public Role findOne(int id);
	public void delete(int id);
	public List<Role> findAll();
	public Role findByRole(String role);

}
