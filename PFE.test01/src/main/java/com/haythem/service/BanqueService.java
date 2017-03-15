package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Banque;
import com.haythem.persistance.Organization;



public interface BanqueService {
	public void save(Banque banque);
	public Banque findOne(Long idbanque);
	public void delete(Long long1);
	public List<Banque> findAll();
	public void update(Long idbanque);
	public void update(Long idbanque,String banqueName,String number,Organization org);
}
