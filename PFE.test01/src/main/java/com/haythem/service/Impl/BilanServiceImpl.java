package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.BilanDao;
import com.haythem.model.BilanModel;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Observation;
import com.haythem.persistance.Seance;
import com.haythem.persistance.User;
import com.haythem.service.BilanService;
import com.haythem.service.ObservationService;
@Service
 public class BilanServiceImpl implements BilanService{

	
	@Autowired
	private BilanDao repository;
	
	@Autowired
	private ObservationService observationService;

	@Override
	public Long save(Bilan bilan) {
		return repository.saveAndFlush(bilan).getId();
	}

	@Override
	public Bilan findOne(Long idBilan) {
		return repository.findOne(idBilan);
	}

	@Override
	public void delete(Long idBilan) {
		try {
			List<Observation> observationList = observationService.findByBilan(findOne(idBilan));
			for (Observation observation : observationList) {
				observationService.delete(observation.getId());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		repository.delete(idBilan);
	}

	@Override
	public List<Bilan> findAll() {
		return repository.findAll();
	}

	@Override
	public Long update(String generateur, String filtre, String poidsSec, String uftDuree, String debutDeDialyse,
			String poidsDebut, String priseDePoids, String tensionarterielleDebutSystolique,
			String tensionarterielleDebutDiastolique, String finDeDialyse, String poidsFin, String perteDePoids,
			String tensionarterielleFinSystolique, String tensionarterielleFinDiastolique, Boolean heparine,
			String traitement, User infirmier, Seance seance, String observationMedicales, String uft, String options){
		Bilan bilan = findBySeance(seance);
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
		bilan.setTraitement(traitement);
		bilan.setUft(uft);
		bilan.setUftDuree(uftDuree);
		bilan.setTensionarterielleDebutDiastolique(tensionarterielleDebutDiastolique);
		bilan.setTensionarterielleDebutSystolique(tensionarterielleDebutSystolique);
		bilan.setTensionarterielleFinDiastolique(tensionarterielleFinDiastolique);
		bilan.setTensionarterielleFinSystolique(tensionarterielleFinSystolique);
		return save(bilan);		
	}

	@Override
	public Bilan findBySeance(Seance seance) {
		 return repository.findBySeance(seance);
	}


	

	

}
