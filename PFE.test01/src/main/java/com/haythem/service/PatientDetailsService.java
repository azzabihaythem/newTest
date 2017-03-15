package com.haythem.service;

import java.util.Date;
import java.util.List;


import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.User;

public interface PatientDetailsService {
	public void save(PatientDetails patientDetails);
	public PatientDetails findOne(Long idpatientDetails);
	public void delete(Long long1);
	public List<PatientDetails> findAll();
	public void save(String idUser,String nom,String prenom,String affile,String numAffilation,String dOIT,Date dateDebut,Date dateFin,String numPriseEnCharge);
	public void save(String nom,String prenom,String affile,String numAffilation,String dOIT,Date dateDebut,Date dateFin);
	public void update(Long idPatientDetails,String nom,String prenom,String affile,String numAffilation,String numPriseEnCharge,String dOIT,Date dateDebut,Date dateFin);
	public void updateByUser(Long userId,String nom,String prenom,String affile,String numAffilation,String dOIT,Date dateDebut,Date dateFin);
	public List<String> findAllName();
	public PatientDetails findByUserLike(User user);
}
