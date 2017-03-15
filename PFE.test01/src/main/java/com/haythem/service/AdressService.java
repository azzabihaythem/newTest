package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Adress;



public interface AdressService {
	public void save(Adress adress);
	public Adress findOne(Long idAdress);
	public void delete(Long long1);
	public List<Adress> findAll();
	public void update(int idAdress);
}
