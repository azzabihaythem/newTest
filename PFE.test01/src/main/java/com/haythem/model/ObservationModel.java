package com.haythem.model;

public class ObservationModel{
	/**
	 * 
	 */
	private Long id;

	private String heure;

	private String tension_arterielle_s;
	
	private String tension_arterielle_d;

	private String heparine;

	private String debit_sang;

	private String uf;

	private String pv;

	private String ptm;

	private String uf_cumule;

	private String observation;
	
	private Long bilanId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
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

	
	public Long getBilanId() {
		return bilanId;
	}



	public void setBilanId(Long bilanId) {
		this.bilanId = bilanId;
	}

	public ObservationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTension_arterielle_s() {
		return tension_arterielle_s;
	}

	public void setTension_arterielle_s(String tension_arterielle_s) {
		this.tension_arterielle_s = tension_arterielle_s;
	}

	public String getTension_arterielle_d() {
		return tension_arterielle_d;
	}

	public void setTension_arterielle_d(String tension_arterielle_d) {
		this.tension_arterielle_d = tension_arterielle_d;
	}

	public ObservationModel(Long id, String heure, String tension_arterielle_s, String tension_arterielle_d,
			String heparine, String debit_sang, String uf, String pv, String ptm, String uf_cumule, String observation,
			Long bilanId) {
		super();
		this.id = id;
		this.heure = heure;
		this.tension_arterielle_s = tension_arterielle_s;
		this.tension_arterielle_d = tension_arterielle_d;
		this.heparine = heparine;
		this.debit_sang = debit_sang;
		this.uf = uf;
		this.pv = pv;
		this.ptm = ptm;
		this.uf_cumule = uf_cumule;
		this.observation = observation;
		this.bilanId = bilanId;
	}

}
