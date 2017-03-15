package com.haythem.model;

import com.haythem.persistance.Information;
import com.haythem.persistance.PatientDetails;

public class PatientDetailsInformationModel {
	private Information information ;
	
	private PatientDetails patientDetails;

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

	public PatientDetailsInformationModel(Information information,
			PatientDetails patientDetails) {
		super();
		this.information = information;
		this.patientDetails = patientDetails;
	}
	
	
	
}
