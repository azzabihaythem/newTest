package com.haythem.service;

import java.util.List;

import com.haythem.persistance.PatientSeanceDays;
import com.haythem.persistance.User;

public interface PatientSeanceDaysService {
	public void save(PatientSeanceDays patientSeanceDays);
	public PatientSeanceDays findOne(Long idPatientSeanceDays);
	public void delete(Long idPatientSeanceDays);
	public List<PatientSeanceDays> findAll();
	public void save(User user,String day);
	
	public void update(Long id,User user,String day);

	void deleteAllByUser(User user);
	public  List<PatientSeanceDays> findByUserLike(User user);
	public void deleteByUser(User user);
}
