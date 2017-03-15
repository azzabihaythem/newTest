package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.UserOrganizationDao;
import com.haythem.persistance.Organization;
import com.haythem.persistance.User;
import com.haythem.persistance.UserOrganization;
import com.haythem.service.UserOrganizationService;
@Service
public class UserOrganizationServiceImpl implements UserOrganizationService {
	@Autowired
	private  UserOrganizationDao repository;
	
	@Override
	public void save(UserOrganization type) {
		repository.saveAndFlush(type);

	}

	@Override
	public UserOrganization findOne(Long type) {
		return repository.findOne(type);
	}

	@Override
	public void delete(Long long1) {
		repository.delete((long) long1);

	}

	@Override
	public List<UserOrganization> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long idType,Organization organization,User user) {
		UserOrganization userOrg = findOne(idType);
		userOrg.setOrganization(organization);
		userOrg.setUser(user);
		save(userOrg);

	}

	@Override
	public void create(Organization organization, User user) {
		UserOrganization userOrg = new UserOrganization();
		userOrg.setOrganization(organization);
		userOrg.setUser(user);
		save(userOrg);
		
	}

}
