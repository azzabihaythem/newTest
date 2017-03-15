package com.haythem.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.haythem.dao.FactureDao;
import com.haythem.model.FactureGlobaleModel;
import com.haythem.persistance.Bordereau;
import com.haythem.persistance.Facture;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.Seance;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;
import com.haythem.service.BordereauService;
import com.haythem.service.FactureService;
import com.haythem.service.InformationService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.SeanceService;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureDao repository;
	
	
	@Autowired
	PatientDetailsService patientDetailsService;
	
	@Autowired
	InformationService informationService;
	
	
	@Autowired
	SeanceService seanceService;
	@Override
	public void save(Facture facture) {
		repository.saveAndFlush(facture);
		
	}

	@Override
	public Facture findOne(Long facture) {
		
		return repository.findOne(facture);
	}

	@Override
	public void delete(Long factureId) {
		repository.delete(factureId);
		
	}

	@Override
	public List<Facture> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long factureId, Date date, Type type,User user,
			String factureNumber, Long seanceNumber) {
		Facture fact = findOne(factureId);
		fact.setDate(date);
//		fact.setFactureNumber(factureNumber);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		fact.setMonth(month+"");
        fact.setSeanceNumber(seanceNumber);
		fact.setSeanceType(type);
		fact.setUser(user);
		fact.setYear(year+"");
		
		save(fact);
		
	}

	@Override
	public void save(Date date, Type type,User user,String factureNumber,String seanceNumber) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
	Facture fact = repository.findByUserAndMonthAndYear(user, month+"", year+"");
//		Facture fact = new Facture();
	

	List<Facture> fact10 = findLast10().getContent();
	if(fact10.size()>0){
		
		factureNumber=(Long.parseLong(fact10.get(0).getFactureNumber())+1)+"";
	}else{
		factureNumber="1";
		
	}
	 
	
	
	
	if(fact==null){
		 fact = new Facture();
		
		fact.setDate(date);
		
		
		
		
		fact.setFactureNumber(factureNumber);
		fact.setSeanceNumber(1L);
		fact.setMonth(month+"");
		fact.setSeanceType(type);
		fact.setUser(user);
		fact.setYear(year+"");
		
		save(fact);
	}else{
		
		update(fact.getId(), date, type, user, factureNumber, Long.parseLong(seanceNumber));
	}
		
	}

	@Override
	public List<Facture> findByuserLike(User user) {
		return repository.findByuserLike(user);
	}

	@Override
	public Facture findByUserAndMonthAndYear(User user, String month,
			String year) {
		
		
//	Facture fact =	repository.findByUserAndMonthAndYear(user, month+"", year+"");
//	
//	if(fact==null){
//		
//	}
		return repository.findByUserAndMonthAndYear(user, month, year);
	}

	@Override
	public List<Facture> CreateGlobalFactureByMonthAndYear(Date date) {
	List<PatientDetails> patientD = patientDetailsService.findAll();
	List<Seance> seanceList = new ArrayList<Seance>();
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	int month = cal.get(Calendar.MONTH);
	int year = cal.get(Calendar.YEAR);
	for(PatientDetails aPatient :patientD){
		seanceList=seanceService.findByUserAndMonthAndYear(aPatient.getUser(), month+"", year+"");
		save(date, seanceList.get(0).getType(), aPatient.getUser(), "1",seanceList.size()+"");
	}
		return (List<Facture>) findByMonthAndYear(month+"",year+"");
	}

	@Override
	public List<Facture> findByMonthAndYear(String month, String year) {
		return repository.findByMonthAndYear(month, year);
	}

	@Override
	public List<FactureGlobaleModel> findByMonthAndYearModel(String month,
			String year) {
		System.out.println(" findByMonthAndYearModel start");
		List<FactureGlobaleModel>  factGlobModelList = new ArrayList<FactureGlobaleModel>();
		List<Facture> factList = findByMonthAndYear( month,  year);
		FactureGlobaleModel fgm = new FactureGlobaleModel();
		
		Long MTHTAXE = 0L;
		Long MTTVA = 0L;
		Long EXONERE = 0L;
		Long MSP = 0L;
		Long seanceNumber =0L;
		for(Facture aFactur :factList ){
			
			seanceNumber = aFactur.getSeanceNumber();
			MTHTAXE = Long.parseLong(aFactur.getSeanceType().getMTHTAXE());
			MTTVA = Long.parseLong(aFactur.getSeanceType().getMTTVA());
			EXONERE = Long.parseLong(aFactur.getSeanceType().getEXONERE());
			MSP = Long.parseLong(aFactur.getSeanceType().getMSP());
			fgm = new FactureGlobaleModel();
			fgm.setExonere(seanceNumber*EXONERE+"");
			fgm.setHorsTax(seanceNumber*MTHTAXE+"");
			fgm.setMsp(seanceNumber*MSP+"");
			
		if(	aFactur.getFactureNumber()==null){
			fgm.setNumFact(aFactur.getId()+"");
		}else{
			fgm.setNumFact(aFactur.getFactureNumber()+"");
			
		}
			fgm.setNumSea(seanceNumber+"");
			fgm.setTtc((EXONERE+MTHTAXE+MSP+MTTVA)*seanceNumber+"");
			fgm.setTva(seanceNumber*MTTVA+"");
			
		    String DATE_FORMAT = "dd/MM/yyyy";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			fgm.setDate(sdf.format(aFactur.getDate()));
			fgm.setAff(patientDetailsService.findByUserLike(aFactur.getUser()).getNumAffilation());
			
			
			fgm.setNom(informationService.findByuserLike(aFactur.getUser()).getFirstName());
			fgm.setPrenom(informationService.findByuserLike(aFactur.getUser()).getLastName());
			
			
			factGlobModelList.add(fgm);
			
			
			System.out.println(" findByMonthAndYearModel end");
			
		}
		return factGlobModelList;
	}

	@Override
	public List<FactureGlobaleModel> CreateGlobalFactureByMonthAndYear2(
			Date date) {
		
		System.out.println(" CreateGlobalFactureByMonthAndYear2 start");
		List<PatientDetails> patientD = patientDetailsService.findAll();
		List<Seance> seanceList = new ArrayList<Seance>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		System.out.println( " month= "+month+" year= "+ year);
		for(PatientDetails aPatient :patientD){
			
			seanceList=seanceService.findByUserAndMonthAndYear(aPatient.getUser(), month+"", year+"");
			if(seanceList.size()>0){
			save(date, seanceList.get(0).getType(), aPatient.getUser(), "1",seanceList.size()+"");
			}
		}
		List<FactureGlobaleModel> lfact = findByMonthAndYearModel(month+"",year+"");
		System.out.println(" CreateGlobalFactureByMonthAndYear2  lfact.size() ="+lfact.size());
		System.out.println(" CreateGlobalFactureByMonthAndYear2 end");
			return lfact;
	}

	@Override
	public Page<Facture> findLast10() {
		  Pageable topTen = new PageRequest(0, 10, Direction.DESC, "id"); 
		  Page<Facture> result = repository.findAll(topTen);
		  
		
		return result;
	}

	@Override
	public void updateFactNumber(User user, String month, String year,
			String number,Date date,Type type) {
		Facture  fact= findByUserAndMonthAndYear(user, month, year);
		if(fact!=null){
			
			fact.setFactureNumber(number);
			save(fact);
		}else{
			
			
			save(date, type, user, number, "1");
			
			
		}
	
		
	}

	@Override
	public void deleteAllByUser(User user) {
		
		for(Facture aFact :repository.findByUser(user)){
			
			delete(aFact.getId());
			
		}
		
	}

	@Override
	public void setBorderauId(Long factureId,Bordereau borderau) {
		Facture fact = findOne(factureId);
		
		
		
//		fact.setDate(date);
//		fact.setFactureNumber(factureNumber);
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		int month = cal.get(Calendar.MONTH);
//		int year = cal.get(Calendar.YEAR);
//		fact.setMonth(month+"");
//        fact.setSeanceNumber(seanceNumber);
//		fact.setSeanceType(type);
//		fact.setUser(user);
//		fact.setYear(year+"");
		fact.setBorderauNumber(borderau);
		save(fact);
		
	}

	@Override
	public 	List<FactureGlobaleModel>  findByBorderauNumber(Bordereau bordereau) {
		// TODO Auto-generated method stub
	
		
			
			List<FactureGlobaleModel>  factGlobModelList = new ArrayList<FactureGlobaleModel>();
		List<Facture> factList =  repository.findByBorderauNumber(bordereau);
		FactureGlobaleModel fgm = new FactureGlobaleModel();
		
		Long MTHTAXE = 0L;
		Long MTTVA = 0L;
		Long EXONERE = 0L;
		Long MSP = 0L;
		Long seanceNumber =0L;
		for(Facture aFactur :factList ){
			
			seanceNumber = aFactur.getSeanceNumber();
			MTHTAXE = Long.parseLong(aFactur.getSeanceType().getMTHTAXE());
			MTTVA = Long.parseLong(aFactur.getSeanceType().getMTTVA());
			EXONERE = Long.parseLong(aFactur.getSeanceType().getEXONERE());
			MSP = Long.parseLong(aFactur.getSeanceType().getMSP());
			fgm = new FactureGlobaleModel();
			fgm.setExonere(seanceNumber*EXONERE+"");
			fgm.setHorsTax(seanceNumber*MTHTAXE+"");
			fgm.setMsp(seanceNumber*MSP+"");
			
		if(	aFactur.getFactureNumber()==null){
			fgm.setNumFact(aFactur.getId()+"");
		}else{
			fgm.setNumFact(aFactur.getFactureNumber()+"");
			
		}
			fgm.setNumSea(seanceNumber+"");
			fgm.setTtc((EXONERE+MTHTAXE+MSP+MTTVA)*seanceNumber+"");
			fgm.setTva(seanceNumber*MTTVA+"");
			
		    String DATE_FORMAT = "dd/MM/yyyy";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			fgm.setDate(sdf.format(aFactur.getDate()));
			fgm.setAff(patientDetailsService.findByUserLike(aFactur.getUser()).getNumAffilation());
			
			
			fgm.setNom(informationService.findByuserLike(aFactur.getUser()).getFirstName());
			fgm.setPrenom(informationService.findByuserLike(aFactur.getUser()).getLastName());
			
			
			factGlobModelList.add(fgm);
			
			
			
			
		}
		return factGlobModelList;
	}

	@Override
	public List<Facture> findListFactureByBorderauNumber(Bordereau bordereau) {
		// TODO Auto-generated method stub
		return repository.findByBorderauNumber(bordereau);
	}

	



	
}
