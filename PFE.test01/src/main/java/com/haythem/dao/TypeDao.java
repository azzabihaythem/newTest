package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Type;

public interface TypeDao extends JpaRepository<Type, Long>{
	Type findByTypeNameLike(String typeName);
}
