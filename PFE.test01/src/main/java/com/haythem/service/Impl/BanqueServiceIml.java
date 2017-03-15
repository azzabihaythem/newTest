package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.BanqueDao;
import com.haythem.persistance.Banque;
import com.haythem.persistance.Organization;
import com.haythem.service.BanqueService;
@Service
public class BanqueServiceIml implements BanqueService {
	
	@Autowired
	private BanqueDao repository;

	@Override
	public void save(Banque banque) {
		repository.saveAndFlush(banque);

	}

	@Override
	public Banque findOne(Long idbanque) {
		
	
		return repository.findOne(idbanque);
		
	}

	@Override
	public void delete(Long long1) {
		repository.delete((long) long1);

	}

	@Override
	public List<Banque> findAll() {
		if(repository.findAll().size()==0){
			Banque banque = new Banque();
			banque.setBaqueName("baqueName");
			banque.setNumber("number");
			save(banque);
			
		}
		return repository.findAll();
	
	}

	@Override
	public void update(Long idbanque) {
		

	}

	@Override
	public void update(Long idbanque, String banqueName, String number,
			Organization org) {
		Banque banque = findAll().get(0);
		banque.setBaqueName(banqueName);
		banque.setNumber(number);
		banque.setOrganization(org);

		save(banque);
		
	}

}
