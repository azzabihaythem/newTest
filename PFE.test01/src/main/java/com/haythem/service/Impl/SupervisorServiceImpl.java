package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;













import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.SupervisorDao;
import com.haythem.persistance.Patient;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;
import com.haythem.service.PatientService;
import com.haythem.service.SupervisorService;
import com.haythem.service.UserService;
@Service
public class SupervisorServiceImpl implements SupervisorService{

	

	@Autowired
	private SupervisorDao repository;
	
	@Autowired
	private PatientService patientService;

	

	@Autowired
	private UserService userService;

	
	
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Supervisor supervisor) {
		repository.saveAndFlush(supervisor);
		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Supervisor findOne(Long idSupervisor) {
		return repository.findOne(idSupervisor);
	}

	@Override
	public void delete(Long idSupervisor) {
		repository.delete(idSupervisor);
		
	}

	@Override
	public List<Supervisor> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(String patient, String user) {
		
		
int test = 1;
		User supervisor = userService.findByUsernameLike(user);
		Patient paTient = patientService.findByUserLike(userService.findByUsernameLike(patient));
		
	
		for(Supervisor u : findAllByPatientLike(paTient)){	
			
			
			if (u.getUser().getUsername().equals(supervisor.getUsername())){
				
				test = 0 ;	
				
			}
			
			
				
		}
		
		
		
		
		if(test==1){
		Supervisor supervisor1 = new Supervisor(patientService.findByUserLike(userService.findByUsernameLike(patient)),
				userService.findByUsernameLike(user));
		
		save(supervisor1);
		}
		
	}

	@Override
	public Supervisor findByUserLike(User user) {
		
		return repository.findByUserLike(user);
	}

	@Override
	public Supervisor findByPatientLike(Patient patient) {
		
		return repository.findByPatientLike(patient);
		
	}
	
	
	//utiliser en cas du supprimé un user Patient
	@Override
	public void deleteAllByPatient(Patient patient) {
		for(Supervisor u : findAll()){
			if (u.getPatient().getId()==patient.getId()){
				System.out.println("deleteAllByPatient");
				repository.delete(u);
               }
		}
	}

	
	
	//utiliser en cas du supprimé un  user superviseur
	@Override
	public void deleteAllByUser(User user) {
		for(Supervisor u : findAll()){
			if (u.getUser().getId()==user.getId()){
				System.out.println("deleteAllByUser");
				repository.delete(u);
               }
		}
		
	}

	@Override
	public List<Supervisor> findAllByPatientLike(Patient patient) {
		
			
		List<Supervisor> supervisorList = new ArrayList<Supervisor>(); 
		if (patient==null){
			return supervisorList;
		}
		
		for(Supervisor u : findAll()){
			if (u.getPatient().getId()==patient.getId()){
				supervisorList.add(u);
               }
		}
		return supervisorList;
	}
	
	@Override
	public List<Supervisor> findAllByUserLike(User user) {
		
		List<Supervisor> supervisorList = new ArrayList<Supervisor>(); 
		for(Supervisor u : findAll()){
			if (u.getUser().getId()==user.getId()){
				supervisorList.add(u);
               }
		}
		return supervisorList;
	}

	@Override
	public String exist(String patient, String user) {
		// TODO Auto-generated method stub
		User supervisor = userService.findByUsernameLike(user);
		Patient paTient = patientService.findByUserLike(userService.findByUsernameLike(patient));
		
	
		for(Supervisor u : findAllByPatientLike(paTient)){	
			
			
			if (u.getUser().getUsername().equals(supervisor.getUsername())){
				
				return "Patient  "+paTient.getUser().getUsername()+" already supervised by  " + u.getUser().getUsername();	
				
			}
			
			
				
		}
		return "";
	}

	
}
