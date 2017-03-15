package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Patient;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;

public interface SupervisorDao extends JpaRepository<Supervisor, Long>{
	
	
	Supervisor findByUserLike(User user);
	Supervisor findByPatientLike(Patient patient);

}
