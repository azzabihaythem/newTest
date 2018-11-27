package com.haythem.service;

import java.util.List;

import com.haythem.model.BilanModel;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Seance;
import com.haythem.persistance.User;

public interface BilanService {
	
	Bilan findBySeance(Seance seance);
	public Long save(Bilan bilan);
	public Bilan findOne(Long idBilan);
	public void delete(Long idBilan);
	public List<Bilan> findAll();
	public Long update(String generateur, String filtre, String poidsSec, String uftDuree, String debutDeDialyse,
			String poidsDebut, String priseDePoids, String tensionarterielleDebutSystolique,
			String tensionarterielleDebutDiastolique, String finDeDialyse, String poidsFin, String perteDePoids,
			String tensionarterielleFinSystolique, String tensionarterielleFinDiastolique, Boolean heparine,
			String traitement, User infirmier, Seance seance, String observationMedicales, String uft, String options);
}
