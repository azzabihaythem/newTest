package com.haythem.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name = "adress")
public class Adress extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "STATE")
	private String state;
	@Column(name = "ADRESS")
	private String adress;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Adress(String country, String state, String adress) {
		this.country = country;
		this.state = state;
		this.adress = adress;
	}
	
	public Adress() {
	}
	
	
	

}
