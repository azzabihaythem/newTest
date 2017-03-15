package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.InformationDao;
import com.haythem.model.InformationModel;
import com.haythem.model.InformationModel2;
import com.haythem.persistance.Adress;
import com.haythem.persistance.Information;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.User;
import com.haythem.service.AdressService;
import com.haythem.service.InformationService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.UserService;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private InformationDao repository;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PatientDetailsService patientDetailsService;
	
	
	@Autowired
	private AdressService adressService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Information information) {
		repository.saveAndFlush(information);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Information findOne(Long idInformation) {
		return repository.findOne(idInformation);
	}

	@Override
	public void delete(Long idInformation) {
		 Long j = findOne(idInformation).getAdress().getId();
		repository.delete((long) idInformation);
		adressService.delete(j);
		

	}

	@Override
	public List<Information> findAll() {
		return repository.findAll();
	}

	@Override
	public Information findByuserLike(User user) {
		return repository.findByuserLike(user);
	}

	@Override
	public void saveInformation(String userId,int identityCardNumber, String firstName, String lastName,
			String email, String birthday, String phoneNumber, String gender
			,String adress,String country,String State ) {
		  System.out.println("start************** find one");
		    User user = userService.findByUsernameLike(userId);
		    System.out.println("end************** find one");
		   Adress adress1 = new Adress(country,State,adress);
		   adressService.save(adress1);
		    Information info = new Information(identityCardNumber,firstName,lastName,email,
				                               birthday,phoneNumber,gender,adress1,user);
		    System.out.println("save info");
		  save(info);
		  System.out.println("end save info");
		
	}

	@Override
	public void editInformation(Long id, int identityCardNumber,
			String firstName, String lastName, String email, String birthday,
			String phoneNumber, String gender, String adress, String country,
			String State) {
		
		Information info = findOne(id);
	
		
	   info.getAdress().setAdress(adress);
	   info.getAdress().setCountry(country);
	   info.getAdress().setState(State);
	   adressService.save(info.getAdress());
	   info.setBirthday(birthday);
	   info.setEmail(email);
	   info.setFirstName(firstName);
	   info.setGender(gender);
	   info.setLastName(lastName);
	   info.setPhoneNumber(phoneNumber);
	   info.setIdentityCardNumber(identityCardNumber);
	   
	   
	   repository.save(info);
	   
	    
		
	}
	
	
	@Override
	public void editPatientInformation(String userName, int identityCardNumber,
			String firstName, String lastName, String email, String birthday,
			String phoneNumber, String gender, String adress, String country,
			String State) {
		
		User  user =	userService.findByUsernameLike(userName);
		Information info;
		
			System.out.println("tryyyyyyyyyyyy");
		    if( findByuserLike(user)==null){
		    	Adress adress1 = new Adress("-","-","-");
		    	adressService.save(adress1);
		    	info = new Information(1,"-","-","-","-","-","-",adress1,user);
		    	save(info);
		    }else{
		    	
		    	info = findByuserLike(user);
		    	
		    }
		    	
			// TODO: handle exception
			System.out.println("catch");
			 
		
	   info.getAdress().setAdress(adress);
	   info.getAdress().setCountry(country);
	   info.getAdress().setState(State);
		adressService.save(info.getAdress());
	   info.setBirthday(birthday);
	   info.setEmail(email);
	   info.setFirstName(firstName);
	   info.setGender(gender);
	   info.setLastName(lastName);
	   info.setPhoneNumber(phoneNumber);
	   info.setIdentityCardNumber(identityCardNumber);
	   
	   
	   repository.save(info);
	   
		
	}
	

	@Override
	public List<String> userNamesAv() {
		List<String> userNamesAv = new ArrayList<String>();
		for(com.haythem.persistance.User u : userService.findAll()){
			if (findByuserLike(u)==null)
			userNamesAv.add(u.getUsername());
				
		}
		return userNamesAv;
	}

	@Override
	public Information findByemailLike(String email) {
		// TODO Auto-generated method stub
		return repository.findByemailLike(email);
	}

	@Override
	public List<InformationModel2> findAll2() {
		patientDetailsService.findAll();
		List<InformationModel2> infList = new ArrayList<InformationModel2>();
		
		InformationModel2 infModel ;
		
		List<PatientDetails> pDetails = patientDetailsService.findAll();
		for (Information inf: repository.findAll()){
			infModel = new InformationModel2();
			infModel.setInf(inf);
			for(PatientDetails pDa:pDetails){
				
				if(inf.getUser()==pDa.getUser()){
					
					infModel.setPatientDetails(pDa);
				}
			}
			infList.add(infModel);
		}
		return infList;
	}
	
	

}
