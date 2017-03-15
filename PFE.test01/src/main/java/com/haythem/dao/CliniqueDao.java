package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Clinique;

public interface CliniqueDao extends JpaRepository<Clinique, Long>{

}
