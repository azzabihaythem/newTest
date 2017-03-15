package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.OrganizationDao;
import com.haythem.persistance.Organization;
import com.haythem.service.OrganizationService;
@Service
public class OrganizationServiceImp implements OrganizationService {

	
	@Autowired
	private OrganizationDao repository;
	
	@Override
	public void save(Organization organization) {
		repository.saveAndFlush(organization);

	}

	@Override
	public Organization findOne(Long idOrganization) {
		return repository.findOne(idOrganization);
	}

	@Override
	public void delete(Long long1) {
		repository.delete((long) long1);

	}

	@Override
	public List<Organization> findAll() {
		return repository.findAll();
		
	}

	@Override
	public void update(Long idOrganization,String nameOrganization) {
		// TODO Auto-generated method stub
		Organization org =findOne(idOrganization);
		org.setNameOrganization(nameOrganization);
		save(org);

	}

}
