package com.haythem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.ObservationDao;
import com.haythem.persistance.Bilan;
import com.haythem.persistance.Observation;
import com.haythem.service.ObservationService;
@Service
 public class ObservationServiceImpl implements ObservationService{

	
	@Autowired
	private ObservationDao repository;

	@Override
	public void save(Observation observation) {
		repository.saveAndFlush(observation);
	}

	@Override
	public Observation findOne(Long idObservation) {
		return repository.findOne(idObservation);
	}

	@Override
	public void delete(Long idObservation) {
		repository.delete(idObservation);
	}

	@Override
	public List<Observation> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long idObservation,String heure, String tension_arterielle_s, String tension_arterielle_d, String heparine,
			String debit_sang, String uf, String pv, String ptm, String uf_cumule, String observation, Bilan bilan) {
		
		Observation obs = findOne(idObservation);
		
		obs.setDebit_sang(debit_sang);
		obs.setHeparine(heparine);
		obs.setHeure(heure);
		obs.setObservation(observation);
		obs.setPtm(ptm);
		obs.setPv(pv);
		obs.setTension_arterielle_s(tension_arterielle_s);
		obs.setTension_arterielle_d(tension_arterielle_d);
		obs.setUf(uf_cumule);
		obs.setUf_cumule(uf_cumule);
		save(obs);
	}

	@Override
	public List<Observation> findByBilan(Bilan bilan) {
		return repository.findByBilan(bilan);
	}

}
