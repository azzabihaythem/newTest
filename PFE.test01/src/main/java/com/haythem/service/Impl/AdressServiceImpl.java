package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.AdressDao;
import com.haythem.persistance.Adress;
import com.haythem.service.AdressService;
@Service
 public class AdressServiceImpl implements AdressService{

	
	@Autowired
	private AdressDao repository;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Adress adress) {
		repository.saveAndFlush(adress);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Adress findOne(Long idAdress) {
		return repository.findOne(idAdress);
	}

	@Override
	public void delete(Long idAdress) {
		repository.delete((long) idAdress);
		
	}

	@Override
	public List<Adress> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(int idAdress) {
		// TODO Auto-generated method stub
		Adress adress = findOne(1L);
		adress.setAdress("hhhdddh");
		adress.setCountry("tunis");
		adress.setState("united");
		
		save(adress);
		
	}
	
	
	

}
