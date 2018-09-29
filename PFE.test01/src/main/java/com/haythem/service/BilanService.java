package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Bilan;

public interface BilanService {
	public void save(Bilan bilan);
	public Bilan findOne(Long idBilan);
	public void delete(Long idBilan);
	public List<Bilan> findAll();
	public void update(int idBilan);
}
