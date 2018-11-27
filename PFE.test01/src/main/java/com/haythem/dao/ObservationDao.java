package com.haythem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Bilan;
import com.haythem.persistance.Observation;

public interface ObservationDao extends JpaRepository<Observation, Long>{
	
	List<Observation> findByBilan(Bilan bilan);
	
}
