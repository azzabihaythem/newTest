package com.haythem.persistance;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "mesure")
public class Mesure extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date date;

	@Column(name = "WATCH_SERIAL_NUMBER")
	private String watchSerialNumber;
	@Column(name = "HEARTBEAT")
	private String heartbeat;// Valeur de battement de coeur par minute
	@Column(name = "TEMPERATURE")
	private String temperature;
	@Column(name = "FALL")
	private String fall; // existance ou non d'un cas de chute

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Mesure(Patient patient, Date date, String watchSerialNumber,
			String heartbeat, String temperature, String fall) {
		this.patient = patient;
		this.date = date;
		this.watchSerialNumber = watchSerialNumber;
		this.heartbeat = heartbeat;
		this.temperature = temperature;
		this.fall = fall;
	}

	public Mesure() {
	}

	@PrePersist
	protected void triggerTimeChane() {
		this.date = Calendar.getInstance().getTime();
	}

}
