package com.haythem.model;





import com.haythem.persistance.Patient;

public class MesureModel {

	
	
	
	
	private Patient patient;

 //	Date date;

	private String watchSerialNumber;
	private String heartbeat;// Valeur de battement de coeur par minute
	private String temperature;
	private String fall; // existance ou non d'un cas de chute
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getWatchSerialNumber() {
		return watchSerialNumber;
	}
	public void setWatchSerialNumber(String watchSerialNumber) {
		this.watchSerialNumber = watchSerialNumber;
	}
	public String getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getFall() {
		return fall;
	}
	public void setFall(String fall) {
		this.fall = fall;
	}
	public MesureModel(Patient patient, String watchSerialNumber,
			String heartbeat, String temperature, String fall) {
		this.patient = patient;
		this.watchSerialNumber = watchSerialNumber;
		this.heartbeat = heartbeat;
		this.temperature = temperature;
		this.fall = fall;
	}
	public MesureModel() {
	
	}
	
	
	
	
	
	
}
