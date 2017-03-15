package com.haythem.model;

import com.haythem.persistance.Information;
import com.haythem.persistance.PatientDetails;




public class InformationModel2 {
	

	
	
	private Information inf;
	private PatientDetails patientDetails;
	public Information getInf() {
		return inf;
	}
	public void setInf(Information inf) {
		this.inf = inf;
	}
	public PatientDetails getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}
	public InformationModel2(Information inf, PatientDetails patientDetails) {
		super();
		this.inf = inf;
		this.patientDetails = patientDetails;
	}
	public InformationModel2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	

}
