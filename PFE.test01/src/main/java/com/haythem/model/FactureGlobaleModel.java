package com.haythem.model;

import com.haythem.persistance.Seance;


public class FactureGlobaleModel implements Comparable<FactureGlobaleModel>{
	
	private String nom;
	private String prenom;
	private String aff;
	private String numFact;
	private String numSea;
	private String horsTax;
	private String tva;
	private String date;
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAff() {
		return aff;
	}
	public void setAff(String aff) {
		this.aff = aff;
	}
	String exonere;
	String msp;
	String ttc;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumFact() {
		return numFact;
	}
	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}
	public String getNumSea() {
		return numSea;
	}
	public void setNumSea(String numSea) {
		this.numSea = numSea;
	}
	public String getHorsTax() {
		return horsTax;
	}
	public void setHorsTax(String horsTax) {
		this.horsTax = horsTax;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public String getExonere() {
		return exonere;
	}
	public void setExonere(String exonere) {
		this.exonere = exonere;
	}
	public String getMsp() {
		return msp;
	}
	public void setMsp(String msp) {
		this.msp = msp;
	}
	public String getTtc() {
		return ttc;
	}
	public void setTtc(String ttc) {
		this.ttc = ttc;
	}
	@Override
	public int compareTo(FactureGlobaleModel o) {
		// TODO Auto-generated method stub
		
		Long long1= Long.parseLong(getNumFact());
		Long long2= Long.parseLong(o.getNumFact());
		 return long1.compareTo(long2);
	}
	
	

}
