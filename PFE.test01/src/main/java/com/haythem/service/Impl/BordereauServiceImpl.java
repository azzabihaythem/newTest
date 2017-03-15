package com.haythem.service.Impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.BordereauDao;
import com.haythem.persistance.Bordereau;
import com.haythem.service.BordereauService;

@Service
public class BordereauServiceImpl implements BordereauService {

	@Autowired
	private BordereauDao repository;
	
	


	@Override
	public void save(Bordereau bordereau) {
		repository.saveAndFlush(bordereau);
		
	}

	@Override
	public Bordereau findOne(Long idBorderau) {
		return repository.findOne(idBorderau);
	}

	@Override
	public void delete(Long idBorderau) {
		repository.delete(idBorderau);
		
	}

	@Override
	public List<Bordereau> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long bordereauId, Date date, String bordereauNumber) {
		Bordereau bordereau = findOne(bordereauId);
		bordereau.setDate(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		bordereau.setMonth(month+"");
		bordereau.setBorderauNumber(bordereauNumber);
		bordereau.setYear(year+"");
		save(bordereau);
		
	}

	@Override
	public void save(Date date, String bordereauNumber) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		Bordereau bordereau = findByMonthAndYear(month+"", year+"");
		
		if(bordereau==null){
		 bordereau = new Bordereau();
		bordereau.setDate(date);
		bordereau.setMonth(month+"");
		bordereau.setBorderauNumber(bordereauNumber);
		bordereau.setYear(year+"");
		save(bordereau);
		}
	}

	@Override
	public Bordereau findByMonthAndYear(String month, String year) {
		// TODO Auto-generated method stub
		return repository.findByMonthAndYear(month, year);
	}

	
	
	
	
	
	
}
