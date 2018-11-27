package com.haythem.model;

public class Tensionarterielle {

	
	private String systolique;
	private String diastolique;
	
	public String getSystolique() {
		return systolique;
	}
	public void setSystolique(String systolique) {
		this.systolique = systolique;
	}
	public String getDiastolique() {
		return diastolique;
	}
	public void setDiastolique(String diastolique) {
		this.diastolique = diastolique;
	}
	public Tensionarterielle(String systolique, String diastolique) {
		super();
		this.systolique = systolique;
		this.diastolique = diastolique;
	}
	public Tensionarterielle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
