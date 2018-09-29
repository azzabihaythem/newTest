package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Observation;

public interface ObservationDao extends JpaRepository<Observation, Long>{

}
