package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Observation;

public interface ObservationService {
	public void save(Observation observation);
	public Observation findOne(Long idObservation);
	public void delete(Long idObservation);
	public List<Observation> findAll();
	public void update(int idObservation);
}
