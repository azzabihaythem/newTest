package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Bilan;
import com.haythem.persistance.Observation;

public interface ObservationService {
	public void save(Observation observation);
	public Observation findOne(Long idObservation);
	public void delete(Long idObservation);
	public List<Observation> findAll();
	public void update(Long idObservation ,String heure, String tension_arterielle, String heparine, String debit_sang, String uf,
			String pv, String ptm, String uf_cumule, String observation, Bilan bilan);
}
