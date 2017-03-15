package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Bordereau;

public interface BordereauDao extends JpaRepository<Bordereau, Long> {
	
    Bordereau findByMonthAndYear(String month,String year);

}
