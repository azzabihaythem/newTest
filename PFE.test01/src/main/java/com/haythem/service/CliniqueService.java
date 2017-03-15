package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Adress;
import com.haythem.persistance.Clinique;



public interface CliniqueService {
	public void save(Clinique clinique);
	public Clinique findOne(Long idClinique);
	public void delete(Long id);
	public List<Clinique> findAll();
	public void save(String nom, String adress, String tva,
			String registreDeCmmerce, String employNumber, String tel,String codeCentre,String codebureauxregional);
	public void update(Long idClinique,String nom, String adress, String tva,
			String registreDeCmmerce, String employNumber, String tel,String codeCentre,String codebureauxregional);
}
