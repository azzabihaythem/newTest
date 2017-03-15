package com.haythem.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Mesure;

public interface MesureDao extends JpaRepository<Mesure, Long>{

	

}
