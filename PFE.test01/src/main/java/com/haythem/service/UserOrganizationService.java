package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Organization;
import com.haythem.persistance.User;
import com.haythem.persistance.UserOrganization;

public interface UserOrganizationService {

	public void save(UserOrganization type);
	public UserOrganization findOne(Long type);
	public void delete(Long long1);
	public List<UserOrganization> findAll();
	public void update(Long idType,Organization organization,User user);
	public void create(Organization organization,User user);
}
