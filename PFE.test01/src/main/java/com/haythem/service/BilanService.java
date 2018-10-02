package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Bilan;
import com.haythem.persistance.Seance;
import com.haythem.persistance.User;

public interface BilanService {
	public void save(Bilan bilan);
	public Bilan findOne(Long idBilan);
	public void delete(Long idBilan);
	public List<Bilan> findAll();
	public void update(Long idBilan,String generateur, String filtre, String poidsSec, String uFTDuree, String debutDeDialyse,
			String poidsDebut, String priseDePoids, String tensionarterielleDebut, String finDeDialyse, String poidsFin,
			String perteDePoids, String tensionarterielleFin, Boolean heparine, String traitement, User infirmier,
			Seance seance, String observationMedicales, String uFT, String options);
}
