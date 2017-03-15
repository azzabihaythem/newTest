package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haythem.persistance.Patient;
import com.haythem.persistance.User;
import com.haythem.persistance.Watch;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {
	
	Patient findByUserLike(User user);
	
	Patient findByWatchLike(Watch watch);
	
	
}
