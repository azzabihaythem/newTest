package com.haythem.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.haythem.persistance.Seance;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;


public interface SeanceService {
	public void save(Seance seance);
	
	
	public List<Seance> findAllSort(Sort sort);
	public Seance findOne(Long seance);
	public void delete(Long long1);
	public List<Seance> findAll();
	public Page<Seance> findAll(Pageable page);
	public void update(Long idSeance,Date date, Type type ,User user) ;
	public void save(Date date, Type type ,User user) ;
	public List<Seance>  findByuserLike(User user);
	
	public List<Seance> findByUserMonthYear(User user,String Month,String Year);
	public List<Seance> findByUserAndMonthAndYear(User user,String month,String year);
	public void deleteAllByUser(User user);
	public Long addAuotomatiqueSeanceBetweenDate(Date date1,Date date2);
	public List<Seance> findByDate(Date date);
	public List<Seance> findByMonthAndYear(String month,String year);
}
