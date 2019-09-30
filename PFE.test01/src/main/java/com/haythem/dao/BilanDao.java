package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Bilan;
import com.haythem.persistance.Seance;

public interface BilanDao extends JpaRepository<Bilan, Long>{
	Bilan findBySeance(Seance seance);
}
