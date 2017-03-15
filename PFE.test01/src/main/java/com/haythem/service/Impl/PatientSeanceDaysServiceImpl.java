package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.PatientSeanceDaysDao;
import com.haythem.persistance.PatientSeanceDays;
import com.haythem.persistance.User;
import com.haythem.service.PatientSeanceDaysService;
@Service
public class PatientSeanceDaysServiceImpl implements PatientSeanceDaysService {

	@Autowired
	private PatientSeanceDaysDao repository;

	@Override
	public void save(PatientSeanceDays patientSeanceDays) {
		repository.saveAndFlush(patientSeanceDays);
		
	}

	@Override
	public PatientSeanceDays findOne(Long idPatientSeanceDays) {
		// TODO Auto-generated method stub
		return repository.findOne(idPatientSeanceDays);
	}

	@Override
	public void delete(Long idPatientSeanceDays) {
		repository.delete(idPatientSeanceDays);
		
	}

	@Override
	public List<PatientSeanceDays> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(User user, String day) {
		PatientSeanceDays psd =  new PatientSeanceDays(user, day);
		save(psd);
		
	}

	@Override
	public void update(Long id, User user, String day) {
		PatientSeanceDays psd = findOne(id);
		psd.setUser(user);
		psd.setDay(day);
		save(psd);
		
		
	}

	@Override
	public  List<PatientSeanceDays> findByUserLike(User user) {
		// TODO Auto-generated method stub
		return repository.findByUserLike(user);
	}

	@Override
	public void deleteByUser(User user) {
		List<PatientSeanceDays> psd = repository.findByUserLike(user);
		for (PatientSeanceDays aPsd:psd){

			delete(aPsd.getId());
		}
		
	}

	@Override
	public void deleteAllByUser(User user) {
		List<PatientSeanceDays> allUserDay = findByUserLike(user);
		
		for (PatientSeanceDays aDay : allUserDay){
			
			delete(aDay.getId());
		}
		
	}
	

}
