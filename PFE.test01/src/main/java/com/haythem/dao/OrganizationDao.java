package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Organization;

public interface OrganizationDao extends JpaRepository<Organization, Long>{

}
