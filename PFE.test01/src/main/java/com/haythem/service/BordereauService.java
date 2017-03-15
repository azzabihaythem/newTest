package com.haythem.service;

import java.util.Date;
import java.util.List;

import com.haythem.persistance.Bordereau;

public interface BordereauService {
	public void save(Bordereau bordereau);
	public Bordereau findOne(Long idBorderau);
	public void delete(Long idBorderau);
	public List<Bordereau> findAll();
	
	public void update(Long factureId,Date date,String BordereauNumber) ;
	public void save(Date date,String BordereauNumber);
	public Bordereau findByMonthAndYear(String month,String year);
//	public Bordereau findByMonthAndYearAndPatientList(String month,String year);

}
