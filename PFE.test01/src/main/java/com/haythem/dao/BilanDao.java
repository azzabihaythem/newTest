package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Bilan;

public interface BilanDao extends JpaRepository<Bilan, Long>{

}
