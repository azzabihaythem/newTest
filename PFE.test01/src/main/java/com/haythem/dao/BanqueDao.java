package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Banque;

public interface BanqueDao extends JpaRepository<Banque, Long>{

}
