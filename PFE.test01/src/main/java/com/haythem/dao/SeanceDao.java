package com.haythem.dao;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Seance;
import com.haythem.persistance.User;

public interface SeanceDao extends JpaRepository<Seance, Long> {
	List<Seance>  findByuserLike(User user);
	   
	
//	  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
	List<Seance> findByUserAndMonthAndYear(User user,String month,String year);
	List<Seance> findByMonthAndYear(String month,String year);
	List<Seance> findByUser(User user);
	List<Seance> findByDate(Date date);
	
//	List<Seance> findAll( Pageable pageable);
	
	
	
	}
