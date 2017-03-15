package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.User;

public interface PatientDetailsDao extends JpaRepository<PatientDetails, Long>{
	PatientDetails findByUserLike(User user);
}
