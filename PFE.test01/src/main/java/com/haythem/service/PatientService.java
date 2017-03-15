package com.haythem.service;

import java.util.List;











import com.haythem.persistance.Patient;
import com.haythem.persistance.User;
import com.haythem.persistance.Watch;


public interface PatientService {
	public void save(Patient patient);
	public Patient findOne(Long cinPatient);
	public void delete(Long id);
	public List<Patient> findAll();
	public void savePatient(String watchSn,String hbRef,String SRef,String userName);
	public void editPatient(Long id,String watchSn,String hbRef,String SRef,String userName);
	public Patient findByUserLike(User user);
	public Patient findByWatchLike(Watch watch);
	public List<String> patientAv();
    public List<String> WatchAv();
    public List<String> patientUserName();
}
