package com.haythem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.persistance.Bordereau;
import com.haythem.persistance.Facture;
import com.haythem.persistance.User;

public interface FactureDao extends JpaRepository<Facture, Long>{
	List<Facture>  findByuserLike(User user);
	   
	
//	  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
      Facture findByUserAndMonthAndYear(User user,String month,String year);
      List<Facture> findByMonthAndYear(String month,String year);
      List<Facture> findByUser(User user);
      List<Facture> findByBorderauNumber(Bordereau bordereau);
      
    
	}
