package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haythem.dao.WatchDao;
import com.haythem.persistance.Patient;
import com.haythem.persistance.Watch;
import com.haythem.service.PatientService;
import com.haythem.service.WatchService;

@Service
public class WatchServiceImpl implements WatchService {

	@Autowired
	private WatchDao repository;
	@Autowired
	private PatientService patientService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Watch watchId) {
		repository.saveAndFlush(watchId);

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Watch findOne(Long watchId) {
		return repository.findOne(watchId);
	}

	@Override
	public void delete(Long watchId) {
		Watch watch = findOne(watchId);
		Patient patient = patientService.findByWatchLike(watch);
		if (patient == null) {
			repository.delete(watchId);
		} else {
         patientService.delete(patient.getId());
         repository.delete(watchId);
		}
	}

	@Override
	public List<Watch> findAll() {
		return repository.findAll();
	}

	@Override
	public void saveWatch(String watchSerialNumber, String hardVersion,
			String softVersion, String communicationType) {
		if(findBywatchSerialNumberLike(watchSerialNumber)==null)
		{
			Watch watch = new Watch(watchSerialNumber, hardVersion, softVersion,
					communicationType);
			repository.save(watch);
		}
	
	}

	@Override
	public void editWatch(Long id, String watchSerialNumber,
			String hardVersion, String softVersion, String communicationType) {
		Watch watch = findOne(id);
		watch.setCommunicationType(communicationType);
		watch.setHardVersion(hardVersion);
		watch.setSoftVersion(softVersion);
		watch.setWatchSerialNumber(watchSerialNumber);
		repository.save(watch);
	}

	@Override
	public Watch findBywatchSerialNumberLike(String watchSerialNumber) {

		return repository.findBywatchSerialNumberLike(watchSerialNumber);
	}

	@Override
	public String existWatch(String watchSerialNumber) {
	if(findBywatchSerialNumberLike(watchSerialNumber)!=null)
	{
		
		return "Watch already saved ";
		
	}
		return "";
	}

}
