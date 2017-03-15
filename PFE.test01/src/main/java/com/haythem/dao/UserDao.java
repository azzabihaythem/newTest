package com.haythem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.haythem.persistance.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>,
		JpaRepository<User, Long> {

	User findByUsernameLike(String username);
	
	List<User> findByRolesLike(String role);
	
	
}
