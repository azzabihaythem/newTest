package com.haythem.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name = "OBSERVATION")
public class Observation extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "HEURE")
	private String heure;
	
	@Column(name = "TENSION_ARTERIELLE")
	private String tension_arterielle;
	
	@Column(name = "HEPARINE")
	private String  heparine ;
	
	@Column(name = "DEBIT_SANG")
	private String  debit_sang ;
	
	@Column(name = "U_F")
	private String  uf ;
	
	@Column(name = "PV")
	private String  pv ;
	
	@Column(name = "PTM")
	private String  ptm ;
	
	@Column(name = "U_F_CUMULE")
	private String  uf_cumule ;
	
	@Column(name = "OBSERVATION")
	private String  observation;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "Bilan")
	private Bilan bilan;
		
	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}


	public String getTension_arterielle() {
		return tension_arterielle;
	}


	public void setTension_arterielle(String tension_arterielle) {
		this.tension_arterielle = tension_arterielle;
	}


	public String getHeparine() {
		return heparine;
	}


	public void setHeparine(String heparine) {
		this.heparine = heparine;
	}


	public String getDebit_sang() {
		return debit_sang;
	}


	public void setDebit_sang(String debit_sang) {
		this.debit_sang = debit_sang;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getPv() {
		return pv;
	}


	public void setPv(String pv) {
		this.pv = pv;
	}


	public String getPtm() {
		return ptm;
	}


	public void setPtm(String ptm) {
		this.ptm = ptm;
	}


	public String getUf_cumule() {
		return uf_cumule;
	}


	public void setUf_cumule(String uf_cumule) {
		this.uf_cumule = uf_cumule;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Observation() {
	}

	public Observation(String heure, String tension_arterielle, String heparine, String debit_sang, String uf,
			String pv, String ptm, String uf_cumule, String observation, Bilan bilan) {
		super();
		this.heure = heure;
		this.tension_arterielle = tension_arterielle;
		this.heparine = heparine;
		this.debit_sang = debit_sang;
		this.uf = uf;
		this.pv = pv;
		this.ptm = ptm;
		this.uf_cumule = uf_cumule;
		this.observation = observation;
		this.bilan = bilan;
	}
	
}
