package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Adress;

public interface AdressDao extends JpaRepository<Adress, Long>{

}
