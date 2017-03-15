package com.haythem.service;

import java.util.List;








import com.haythem.persistance.Mesure;
import com.haythem.persistance.Patient;

public interface MesureService {
	public void save(Mesure mesure);
	public Mesure findOne(Long idMesure);
	public void delete(Long id);
	public List<Mesure> findAll();
	public void saveMesure(String input);
	public void saveMesureUdp(String input);
	public void deleteAllByPatient(Patient patient);
	public List<Mesure>  findAllMesureByPatient(String username);
	public List<Mesure> findAllSupervised(String supervisorName);
	public List<Mesure> findByUser(String userName);

}
