package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.RoleDAO;
import com.haythem.persistance.Role;
import com.haythem.service.RoleService;
@Service
public class RoleServiceImpl  implements RoleService{

	
	@Autowired
	private RoleDAO repository;
	
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(role);
		
	}



	@Override
	public void delete(int id) {
		repository.delete((long) id);
		
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}



	@Override
	public Role findOne(int id) {
		return repository.findOne((long) id);
	}



	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		repository.findByRole(role);
		return null;
	}

}
