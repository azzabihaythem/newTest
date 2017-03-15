package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Patient;
import com.haythem.persistance.Supervisor;
import com.haythem.persistance.User;

public interface SupervisorService {

	public void save(Supervisor supervisor);
	public Supervisor findOne(Long idSupervisor);
	public void delete(Long id);
	public List<Supervisor> findAll();
	public void save(String patient, String user);
	public Supervisor findByUserLike (User user);
	public Supervisor findByPatientLike(Patient patient);
	public List<Supervisor> findAllByPatientLike(Patient patient);
	public List<Supervisor> findAllByUserLike(User user);
	public void deleteAllByPatient(Patient patient);
	public void deleteAllByUser(User user);
	public String exist(String patient, String user);
}
