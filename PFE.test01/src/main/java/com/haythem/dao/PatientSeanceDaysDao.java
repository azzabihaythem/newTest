package com.haythem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.PatientSeanceDays;
import com.haythem.persistance.User;

public interface PatientSeanceDaysDao extends JpaRepository<PatientSeanceDays, Long>{
	List<PatientSeanceDays> findByUserLike(User user);
	
	
}
