package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.BilanDao;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Seance;
import com.haythem.persistance.User;
import com.haythem.service.BilanService;
@Service
 public class BilanServiceImpl implements BilanService{

	
	@Autowired
	private BilanDao repository;

	@Override
	public void save(Bilan bilan) {
		repository.saveAndFlush(bilan);
	}

	@Override
	public Bilan findOne(Long idBilan) {
		return repository.findOne(idBilan);
	}

	@Override
	public void delete(Long idBilan) {
		repository.delete(idBilan);
	}

	@Override
	public List<Bilan> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long idBilan, String generateur, String filtre, String poidsSec, String uFTDuree, String debutDeDialyse,
			String poidsDebut, String priseDePoids, String tensionarterielleDebut, String finDeDialyse, String poidsFin,
			String perteDePoids, String tensionarterielleFin, Boolean heparine, String traitement, User infirmier,
			Seance seance, String observationMedicales, String uFT, String options){
		Bilan bilan = findOne(idBilan);
		bilan.setDebutDeDialyse(debutDeDialyse);
		bilan.setFiltre(filtre);
		bilan.setFinDeDialyse(finDeDialyse);
		bilan.setGenerateur(generateur);
		bilan.setHeparine(heparine);
		bilan.setInfirmier(infirmier);
		bilan.setObservationMedicales(observationMedicales);
		bilan.setOptions(options);
		bilan.setPerteDePoids(perteDePoids);
		bilan.setPoidsDebut(poidsDebut);
		bilan.setPoidsFin(poidsFin);
		bilan.setPoidsSec(poidsSec);
		bilan.setPriseDePoids(priseDePoids);
		bilan.setSeance(seance);
		bilan.setTensionarterielleDebut(tensionarterielleDebut);
		bilan.setTensionarterielleFin(tensionarterielleFin);
		bilan.setTraitement(traitement);
		bilan.setUFT(uFT);
		bilan.setUFTDuree(uFTDuree);
		
		save(bilan);		
	}
	
	
	
	
	
	
	

	

}
