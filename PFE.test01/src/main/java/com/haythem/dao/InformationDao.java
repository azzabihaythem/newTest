package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Information;
import com.haythem.persistance.User;


public interface InformationDao extends JpaRepository<Information, Long>{

	
	
	
	Information findByuserLike(User user);
	Information findByemailLike(String email);
}
