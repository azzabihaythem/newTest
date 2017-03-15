package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.PatientDetailsDao;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.User;
import com.haythem.service.BordereauService;
import com.haythem.service.FactureService;
import com.haythem.service.InformationService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.SeanceService;
import com.haythem.service.TypeService;
import com.haythem.service.UserService;
@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

	@Autowired
	private PatientDetailsDao repository;
	@Autowired
	private UserService userService;
	@Autowired
	private InformationService informationService;
	
	@Autowired
	private SeanceService seanceService;
	@Autowired
	private TypeService typeService;
	@Autowired
	FactureService factureService;
	@Autowired
	BordereauService bordereauService;
	
	@Override
	public void save(PatientDetails patientDetails) {
		repository.saveAndFlush(patientDetails);

	}

	@Override
	public PatientDetails findOne(Long idpatientDetails) {
	return repository.findOne(idpatientDetails);
	
	}

	@Override
	public void delete(Long long1) {
		
		
		PatientDetails patientDetails = findOne(long1);
		
		try {
			seanceService.deleteAllByUser(patientDetails.getUser());
			factureService.deleteAllByUser(patientDetails.getUser());
			informationService.delete(informationService.findByuserLike(patientDetails.getUser())
					.getId());

		} catch (Exception e) {
			// TODO: handle exception
			// throw new IllegalArgumentException();
		}
		repository.delete((long) long1);

	}

	@Override
	public List<PatientDetails> findAll() {
		return repository.findAll();
		
	}
	
	
	@Override
	public List<String> findAllName() {
//		return repository.findAll();
		
		 List<String> patientAv = new ArrayList<String>();
		   System.out.println("patient");
			for(com.haythem.persistance.PatientDetails u : repository.findAll()){
            
					patientAv.add(u.getUser().getUsername());
            
					}
		return patientAv;
		
	}


	@Override
	public void update(Long idPatientDetails,String nom,String prenom,String affile,String numAffilation,String numPriseEnCharge,String dOIT,Date dateDebut,Date dateFin) {
		PatientDetails patientDetails = findOne(idPatientDetails);
		patientDetails.setAffile(affile);
	if(dateDebut==null||"".equals(dateDebut+"")){
		
	}else{
		
		patientDetails.setDateDebut(dateDebut);
	}
	if(dateFin==null||"".equals(dateFin+"")){
		
	}else{
		
		patientDetails.setDateFin(dateFin);
	}
		patientDetails.setDOIT(dOIT);
		patientDetails.setNumAffilation(numAffilation);
		patientDetails.setNumPriseEnCharge(numPriseEnCharge);
		save(patientDetails);
		
	}

	@Override
	public void updateByUser(Long userId,String nom,String prenom, String affile, String numAffilation,
			String dOIT, Date dateDebut, Date dateFin) {
//		userService.findOne(userId);
//		PatientDetails patientDetails = findOne(idPatientDetails);
//		patientDetails.setAffile(affile);
//		patientDetails.setDateDebut(dateDebut);
//		patientDetails.setDateFin(dateFin);
//		patientDetails.setDOIT(dOIT);
//		patientDetails.setNumAffilation(numAffilation);
		
	}

	@Override
	public void save(String affile,String nom,String prenom, String numAffilation, String dOIT,
			Date dateDebut, Date dateFin) {
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setAffile(affile);
	
		patientDetails.setDateDebut(dateDebut);
		patientDetails.setDateFin(dateFin);
		patientDetails.setDOIT(dOIT);
		patientDetails.setNumAffilation(numAffilation);
		save(patientDetails);
		
	}

	@Override
	public PatientDetails findByUserLike(User user) {
		// TODO Auto-generated method stub
		return repository.findByUserLike(user);
	}

	@Override
	public void save(String idUser, String nom, String prenom, String affile,
			String numAffilation, String dOIT, Date dateDebut, Date dateFin,String numPriseEnCharge) {
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setUser(userService.findByUsernameLike(idUser));
		patientDetails.setAffile(affile);
	    patientDetails.setNumPriseEnCharge(numPriseEnCharge);
		patientDetails.setDateDebut(dateDebut);
		patientDetails.setDateFin(dateFin);
		patientDetails.setDOIT(dOIT);
		patientDetails.setNumAffilation(numAffilation);
		save(patientDetails);
		
	}

}
