package com.haythem.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name = "watch")
public class Watch extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "WATCH_SERIAL_NUMBER")
	private String watchSerialNumber;
	@Column(name = "HARD_VERSION")
	private String hardVersion;
	@Column(name = "SOFT_VERSION")
	private String softVersion;
	@Column(name = "COMMUNICATION_TYPE")
	private String communicationType;
	public String getWatchSerialNumber() {
		return watchSerialNumber;
	}
	public void setWatchSerialNumber(String watchSerialNumber) {
		this.watchSerialNumber = watchSerialNumber;
	}
	public String getHardVersion() {
		return hardVersion;
	}
	public void setHardVersion(String hardVersion) {
		this.hardVersion = hardVersion;
	}
	public String getSoftVersion() {
		return softVersion;
	}
	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
	public String getCommunicationType() {
		return communicationType;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public Watch(String watchSerialNumber, String hardVersion,
			String softVersion, String communicationType) {
		this.watchSerialNumber = watchSerialNumber;
		this.hardVersion = hardVersion;
		this.softVersion = softVersion;
		this.communicationType = communicationType;
	}
	public Watch() {
	}
	
	

}
