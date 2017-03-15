package com.haythem.service;

import java.util.Date;

import com.haythem.persistance.Bordereau;
import com.haythem.persistance.User;

public interface FctrsService {

	public String createTextFile(Date date);
	
	public String borderauLine(Date date);
	public String borderauLine2017(Date date);
	public String factureLine(Date date,User user);
	public String factureLine2017(Date date,User user);
	public String complementfactureLine(Bordereau bordereau);
	
}
