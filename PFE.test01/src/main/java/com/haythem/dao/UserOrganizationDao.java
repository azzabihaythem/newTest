package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.haythem.persistance.UserOrganization;

public interface UserOrganizationDao extends CrudRepository<UserOrganization, Long>,
JpaRepository<UserOrganization, Long>{

}
