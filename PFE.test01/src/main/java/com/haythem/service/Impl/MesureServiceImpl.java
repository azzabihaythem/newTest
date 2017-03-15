package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.MesureDao;
import com.haythem.persistance.Mesure;
import com.haythem.persistance.Patient;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;
import com.haythem.persistance.Watch;
import com.haythem.service.MesureService;
import com.haythem.service.PatientService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;
@Service
public class MesureServiceImpl implements MesureService{

	
	@Autowired
	private MesureDao repository;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WatchService watchService;
	
	@Autowired
	private SupervisorService supervisorService;


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Mesure mesure) {
		repository.saveAndFlush(mesure);
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Mesure findOne(Long idMesure) {
		return repository.findOne(idMesure);
	}

	@Override
	public void delete(Long idMesure) {
		repository.delete(idMesure);
		
	}

	@Override
	public List<Mesure> findAll() {
		return repository.findAll();
	}

	@Override
	public void saveMesure(String input) {
		
		 Mesure mesure = new Mesure();
		try {
			System.out.print("*****************start tcp1 ");
			System.out.print(input);
			String watchSerialNumber = (char) Integer.parseInt(input.split(",")[0])
					+""
					+(char) Integer.parseInt(input.split(",")[1])
					+(char) Integer.parseInt(input.split(",")[2])
					+(char) Integer.parseInt(input.split(",")[3]);
			
			String Fall = (char) Integer.parseInt(input.split(",")[4])+"";
			
			String Temp = (char) Integer.parseInt(input.split(",")[5])+""
					+(char) Integer.parseInt(input.split(",")[6])
					+(char) Integer.parseInt(input.split(",")[7])+"";
			
			String Hbeat = (char) Integer.parseInt(input.split(",")[8])+""
					+(char) Integer.parseInt(input.split(",")[9])
					+(char) Integer.parseInt(input.split(",")[10]);
			System.out.print("***************** tcp 2");
			//double Temp = Double.parseDouble(Temp1);
			
			
			System.out.print("watchSerialNumber = ");
			System.out.println(watchSerialNumber); 
			System.out.print("Fall = ");
			System.out.println(Fall); 
			System.out.print("Temp = ");
			System.out.println(Temp); 
			System.out.print("Hbeat = ");
			System.out.println(Hbeat); 
			System.out.print("***************** tcp 2");
			
		Watch watch = watchService.findBywatchSerialNumberLike(watchSerialNumber);
		Patient patient =	patientService.findByWatchLike(watch);
		
		
	  
	   mesure.setFall(Fall);
	   mesure.setHeartbeat(Hbeat);
	   mesure.setPatient(patient);
	   mesure.setTemperature(Temp);
	   mesure.setWatchSerialNumber(watchSerialNumber);
		
		System.out.println(patient.getUser().getUsername());
		System.out.print("***************** tcp 2");	
		} catch (Exception e) {
			
			// TODO: handle exception
			
//			   mesure.setFall("0");
//			   mesure.setHeartbeat(input);
//			   mesure.setPatient(null);
//			   mesure.setTemperature("0");
//			   mesure.setWatchSerialNumber("0");
		}
		
	save(mesure);
	}
	
	@Override
	public void saveMesureUdp(String input) {
		 Mesure mesure = new Mesure();
		
		try {
			String watchSerialNumber = input.substring(0, 4);
			String Fall = input.substring(4	, 5);
			String Temp = input.substring(5, 8);
			String Hbeat =input.substring(8, 11);
			
			//double Temp = Double.parseDouble(Temp1);
			
			System.out.print("watchSerialNumber = ");
			System.out.println(watchSerialNumber); 
			System.out.print("Fall = ");
			System.out.println(Fall); 
			System.out.print("Temp = ");
			System.out.println(Temp); 
			System.out.print("Hbeat = ");
			System.out.println(Hbeat); 
			if( watchService.findBywatchSerialNumberLike(watchSerialNumber)!=null){
				Watch watch = watchService.findBywatchSerialNumberLike(watchSerialNumber);
				Patient patient =	patientService.findByWatchLike(watch);
				
			 
			   mesure.setFall(Fall);
			   mesure.setHeartbeat(Hbeat);
			   mesure.setPatient(patient);
			   mesure.setTemperature(Temp);
			   mesure.setWatchSerialNumber(watchSerialNumber);
				
				System.out.println(patient.getUser().getUsername());
					
				
				
			}else{
//				   mesure.setFall("0");
//				   mesure.setHeartbeat(input);
//				   mesure.setPatient(null);
//				   mesure.setTemperature("0");
//				   mesure.setWatchSerialNumber(null);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
//			   mesure.setFall("0");
//			   mesure.setHeartbeat(input);
//			   mesure.setPatient(null);
//			   mesure.setTemperature("0");
//			   mesure.setWatchSerialNumber(null);
		}
		
		 
		
		save(mesure);
	}

	
	@Override
	public void deleteAllByPatient(Patient patient) {
		for(Mesure u : findAll()){
			if (u.getPatient().getId()==patient.getId()){
				repository.delete(u);
               }
		}
	}
	
	
	@Override
	public List<Mesure> findAllMesureByPatient(String userName) {
		List<Mesure> mesures = new ArrayList<Mesure>();
	try {
		Patient patient = patientService.findByUserLike(userService.findByUsernameLike(userName));

		for(Mesure u : findAll()){
			if (u.getPatient().getId()==patient.getId()){
				 mesures.add(u);
               }
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
		return  mesures;
	}

	@Override
	public List<Mesure> findAllSupervised(String supervisorName) {
		
		User user = userService.findByUsernameLike(supervisorName);
		List<Supervisor> supervisor = supervisorService.findAllByUserLike(user);
		List<Mesure> mesures = new ArrayList<Mesure>();
		List<Mesure> mList = findAll();
		for(Supervisor su : supervisor){
		    for(Mesure u : mList){
		    	if(su.getPatient().getId()==u.getPatient().getId()){
				 mesures.add(u);
               }
		}
		
		}
		return mesures;
	}

	@Override
	public List<Mesure> findByUser(String userName) {
		// TODO Auto-generated method stub
		List<Mesure> mesures = new ArrayList<Mesure>();
		User user = userService.findByUsernameLike(userName);
		if (user.getRoles().get(0).getId() == 1) {
			
			mesures = findAll();
			
		}else if ( user.getRoles().get(0).getId() == 2) {
			
			mesures = findAllMesureByPatient(userName);
			
		}else{
			
			mesures = findAllSupervised(userName);
		}
		
		return mesures;
	}
	
	
	

}
