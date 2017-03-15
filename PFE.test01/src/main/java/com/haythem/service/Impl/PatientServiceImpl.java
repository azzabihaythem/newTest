package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.PatientDao;
import com.haythem.persistance.Patient;
import com.haythem.persistance.User;
import com.haythem.persistance.Watch;
import com.haythem.service.MesureService;
import com.haythem.service.PatientService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
import com.haythem.service.WatchService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao repository;
	@Autowired
	private WatchService watchService;
	@Autowired
	private UserService userService;
	@Autowired
	private MesureService measurementService;
	@Autowired
	private SupervisorService supervisorService;

	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Patient patient) {
		repository.saveAndFlush(patient);

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Patient findOne(Long cinPatient) {
		return repository.findOne(cinPatient);
	}

	@Override
	public void delete(Long cinPatient) {
		Patient patient = findOne(cinPatient);
		supervisorService.deleteAllByPatient(patient);
		measurementService.deleteAllByPatient(patient);
		repository.delete(cinPatient);

	}

	@Override
	public List<Patient> findAll() {
		return repository.findAll();
	}

	
	@Override
	public void savePatient(String watchSn, String hbRef, String SRef, String userName) {
		Watch watch = watchService.findBywatchSerialNumberLike(watchSn);
		User user = userService.findByUsernameLike(userName);
		Patient patient = new Patient(watch, hbRef, SRef, user);
		repository.save(patient);
	}

	@Override
	public void editPatient(Long id,String watchSn, String hbRef, String SRef,
			String userName) {
		Watch watch = watchService.findBywatchSerialNumberLike(watchSn);
		User user = userService.findByUsernameLike(userName);
		System.out.println("******1*****");
		Patient patient =findOne(id);
		patient.setHbRef(hbRef);
		patient.setSRef(SRef);
	    patient.setUser(user);
	    patient.setWatch(watch);
		System.out.println("******2*****");
		repository.save(patient);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findByUserLike(User user) {
		return repository.findByUserLike(user);
	}

	@Override
	public Patient findByWatchLike(Watch watch) {
		return repository.findByWatchLike(watch);
	}

	@Override
	public List<String> patientAv() {
		 List<String> patientAv = new ArrayList<String>();
		   System.out.println("patient");
			for(com.haythem.persistance.User u : userService.findAll()){
               if (u.getRoles().get(0).getId()==2){
              	if(findByUserLike(u)==null)
					patientAv.add(u.getUsername());
               }
					}
		return patientAv;
	}

	@Override
	public List<String> WatchAv() {
		 List<String> WatchAv = new ArrayList<String>();
		   System.out.println("patient");
			for(com.haythem.persistance.Watch u : watchService.findAll()){
              	if(findByWatchLike(u)==null)
              		WatchAv.add(u.getWatchSerialNumber());
					}
		return WatchAv;
	}

	@Override
	public List<String> patientUserName() {
		 List<String> patientAv = new ArrayList<String>();
		   System.out.println("patient");
			for(com.haythem.persistance.Patient u : findAll()){
					patientAv.add(u.getUser().getUsername());
					}
		return patientAv;
	}
	
	

	

}
