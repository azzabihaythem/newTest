package com.haythem.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.haythem.model.FactureGlobaleModel;
import com.haythem.persistance.Bordereau;
import com.haythem.persistance.Facture;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;

public interface FactureService {
	public void save(Facture facture);
	public Facture findOne(Long facture);
	public void delete(Long factureId);
	public List<Facture> findAll();
	public void update(Long factureId,Date date, Type type ,User user,String factureNumber,Long seanceNumber) ;
	public void save(Date date, Type type ,User user,String factureNumber,String seanceNumber);
	public List<Facture>  findByuserLike(User user);
	public Facture findByUserAndMonthAndYear(User user,String month,String year);
	public List<Facture> findByMonthAndYear(String month,String year);
	public List<Facture> CreateGlobalFactureByMonthAndYear(Date date);
	public List<FactureGlobaleModel> CreateGlobalFactureByMonthAndYear2(Date date);
//	public HashMap<Facture,PatientDetails>  findByUserAndMonthAndYearP(User user,String month,String year);
	public List<FactureGlobaleModel> findByMonthAndYearModel(String month,String year);
	public Page<Facture> findLast10();
	public void updateFactNumber(User user,String month,String year,String number,Date date,Type type);
	public void deleteAllByUser(User user);
	public void setBorderauId(Long factureId,Bordereau borderau);
	public  List<FactureGlobaleModel>  findByBorderauNumber(Bordereau bordereau);
	public  List<Facture>  findListFactureByBorderauNumber(Bordereau bordereau);
}
