package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Organization;

public interface OrganizationService {
	public void save(Organization organization);
	public Organization findOne(Long idOrganization);
	public void delete(Long long1);
	public List<Organization> findAll();
	public void update(Long idOrganization,String nameOrganization);

}
