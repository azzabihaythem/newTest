package com.haythem.model;


public class WatchModel {

	
	private String id;
	private String watchSerialNumber;
	private String hardVersion;
	private String softVersion;
	private String communicationType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public WatchModel(String id, String watchSerialNumber, String hardVersion,
			String softVersion, String communicationType) {
		this.id = id;
		this.watchSerialNumber = watchSerialNumber;
		this.hardVersion = hardVersion;
		this.softVersion = softVersion;
		this.communicationType = communicationType;
	}
	public WatchModel() {
	}
	
	
}
