package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.haythem.dao.SeanceDao;
import com.haythem.persistance.Facture;
import com.haythem.persistance.PatientDetails;
import com.haythem.persistance.PatientSeanceDays;
import com.haythem.persistance.Seance;
import com.haythem.persistance.Type;
import com.haythem.persistance.User;
import com.haythem.service.FactureService;
import com.haythem.service.PatientDetailsService;
import com.haythem.service.PatientSeanceDaysService;
import com.haythem.service.SeanceService;
import com.haythem.service.TypeService;

@Service
public class SeanceServiceImpl implements SeanceService {

	@Autowired
	private SeanceDao repository;
	@Autowired
	FactureService factureService;
	@Autowired
	PatientDetailsService patientDetailsService;
	@Autowired
	PatientSeanceDaysService patientSeanceDaysService;
	@Autowired
	TypeService typeService;

	@Override
	public void save(Seance seance) {
		
		try{
		repository.saveAndFlush(seance);
		}catch(Exception e){
			
			e.printStackTrace();
		}

	}

	@Override
	public Seance findOne(Long seance) {
		return repository.findOne(seance);
	}

	@Override
	public void delete(Long long1) {
		repository.delete((long) long1);

	}

	@Override
	public List<Seance> findAll() {
		return repository.findAll();

	}

	@Override
	public void update(Long idSeance, Date date, Type type, User user) {
		Seance seance = findOne(idSeance);
		seance.setDate(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		seance.setMonth(month+"");
		seance.setYear(year+"");
		seance.setType(type);
		seance.setUser(user);
		Facture fact = factureService.findByUserAndMonthAndYear(user, month+"", year+"");
		if(fact==null){
			
         factureService.save(date, type, user, "1","1");
         fact = factureService.findByUserAndMonthAndYear(user, month+"", year+"");
		}
       seance.setFacture(fact);
		save(seance);
		

	}

	@Override
	public void save(Date date, Type type, User user) {
		Seance seance = new Seance();
		seance.setDate(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		seance.setMonth(month+"");
		seance.setYear(year+"");
		seance.setType(type);
		seance.setUser(user);
		Facture fact = factureService.findByUserAndMonthAndYear(user, month+"", year+"");
		if(fact==null){
			
         factureService.save(date, type, user, "1","1");
         fact = factureService.findByUserAndMonthAndYear(user, month+"", year+"");
		}
       seance.setFacture(fact);
		save(seance);

	}

	@Override
	public List<Seance> findByuserLike(User user) {
		// TODO Auto-generated method stub
		return repository.findByuserLike(user);
	}

	@Override
	public List<Seance> findByUserMonthYear(User user, String Month, String Year) {
		List<Seance> seanceList1 = repository.findByuserLike(user);
		List<Seance> seanceList2 = new ArrayList<Seance>();
		for (Seance aSeance : seanceList1) {

			if (Month.equals(aSeance.getDate().getMonth() + "")
					&& Year.equals(aSeance.getDate().getYear() + "")) {
				
				seanceList2.add(aSeance);
			}

		}
		return seanceList2;
	}

	@Override
	public List<Seance> findByUserAndMonthAndYear(User user, String month,
			String year) {
		
		return repository.findByUserAndMonthAndYear(user, month, year);
	}

	@Override
	public void deleteAllByUser(User user) {
for(Seance aSeance :repository.findByUser(user)){
			
			delete(aSeance.getId());
			
		}
		
	}

	@Override
	public Long addAuotomatiqueSeanceBetweenDate(Date date1, Date date2) {
		
		 List<Date> dates = new ArrayList<Date>();
		    Calendar calendar = new GregorianCalendar();
		    calendar.setTime(date1);
		    Date result = calendar.getTime();
		 while (calendar.getTime().before(date2))
		    {
			     result = calendar.getTime();
		        dates.add(result);
		        calendar.add(Calendar.DATE, 1);
		    }
		 
		     result = calendar.getTime();
	        dates.add(result);
//	        calendar.add(Calendar.DATE, 1);//************
		 List<PatientDetails> lpds = patientDetailsService.findAll();
		 String  dayOfWeek ="";
		 
		 List<PatientSeanceDays> listDaysPatient = new ArrayList<PatientSeanceDays>();
		 for(Date dt:dates){
			 dayOfWeek=getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
			 calendar.setTime(dt);
			 System.out.println(dayOfWeek );

			for(PatientDetails pds:lpds){
				listDaysPatient = new ArrayList<PatientSeanceDays>();
				listDaysPatient  =	patientSeanceDaysService.findByUserLike(pds.getUser());
				for(PatientSeanceDays psd:listDaysPatient ){
					if(dayOfWeek.equals(psd.getDay())){
						
						save(dt, typeService.findAll().get(0), psd.getUser());
						
					}
					
					
				}
				
			}
			 
			 
		 }
		
		
		return null;
	}

	
	public String getDayOfWeek(int day){
		String  dayOfWeek ="";
		switch(day){
	      case 1:
	    	  dayOfWeek = "Monday";
//	           System.out.println("The day of the week for this month is Monday.");
	    	  break;
	      case 2:
	    	  dayOfWeek = "Tuesday";
//	           System.out.println("The day of the week for this month is Tuesday.");
	    	  break;
	      case 3:
	    	  dayOfWeek = "Wednesday";
//	           System.out.println("The day of the week for this month is Wednesday.");
	    	  break;
	      case 4:
	    	  dayOfWeek ="Thursday";
//	           System.out.println("The day of the week for this month is Thursday.");
	    	  break;
	      case 5:
	    	  dayOfWeek = "Friday";
//	           System.out.println("The day of the week for this month is Friday.");
	    	  break;
	      case 6:
	    	  dayOfWeek= "Saturday";
//	           System.out.println("The day of the week for this month is Saturday.");
	    	  break;
	      case 7:
	    	  dayOfWeek ="Sunday";
//	           System.out.println("The day of the week for this month is Sunday.");
	    	  break;   
		}
		
		return dayOfWeek;
	}

	@Override
	public List<Seance> findByDate(Date date) {
		
		return repository.findByDate(date);
	}

	@Override
	public List<Seance> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		
		
		return findAllSort(sort);
	}

	@Override
	public List<Seance> findByMonthAndYear(String month, String year) {
		// TODO Auto-generated method stub
		return repository.findByMonthAndYear(month, year);
	}

	@Override
	public Page<Seance> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return repository.findAll(page);
	}


	
}
