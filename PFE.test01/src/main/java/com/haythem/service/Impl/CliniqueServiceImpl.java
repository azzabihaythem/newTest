package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.CliniqueDao;
import com.haythem.persistance.Adress;
import com.haythem.persistance.Clinique;
import com.haythem.service.CliniqueService;
@Service
 public class CliniqueServiceImpl implements CliniqueService{

	
	@Autowired
	private CliniqueDao repository;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Clinique Clinique) {
		repository.saveAndFlush(Clinique);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Clinique findOne(Long idClinique) {
		
	
		return repository.findOne(idClinique);
	}

	@Override
	public void delete(Long idClinique) {
		repository.delete((long) idClinique);
		
	}

	@Override
	public List<Clinique> findAll() {
		if(repository.findAll().size()==0){
			Clinique clinique = new Clinique("nom", "adress", "tva", "registreDeCmmerce", "employNumber", "tel","00000","00");
		save(clinique);
		}
		return repository.findAll();
	}

	@Override
	public void update(Long idClinique,String nom, String adress, String tva,
			String registreDeCmmerce, String employNumber, String tel,String codeCentre,String codebureauxregional) {
		// TODO Auto-generated method stub
		Clinique clinique = findAll().get(0);
		clinique.setNom(nom);
		clinique.setAdress(adress);
		clinique.setTva(tva);
		clinique.setRegistreDeCmmerce(registreDeCmmerce);
		clinique.setEmployNumber(employNumber);
		clinique.setTel(tel);
		clinique.setCodecentre(codeCentre);
		clinique.setCodebureauxregional(codebureauxregional);
		save(clinique);
		
	}

	@Override
	public void save(String nom, String adress, String tva,
			String registreDeCmmerce, String employNumber, String tel,String codeCentre,String codebureauxregional) {
		Clinique clinique = new Clinique(nom, adress, tva, registreDeCmmerce, employNumber, tel,codeCentre,codebureauxregional);
		save(clinique);
		
	}
	
	
	

}
