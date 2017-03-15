package com.haythem.persistance;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Clinique")
public class Clinique extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name = "nom")
	private String nom; 
	
	public Clinique() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "adress")
	private String adress;
	@Column(name = "tva")
	private String tva;
	@Column(name = "registredecommerce")
	private String registreDeCmmerce;
	
	@Column(name = "employNumber")
	private String employNumber;
	@Column(name = "tel")
	private String tel;
	@Column(name = "codecentre")
	private String codecentre;
	
	@Column(name = "codebureauxregional")
	private String codebureauxregional;
	
	
	public String getCodebureauxregional() {
		return codebureauxregional;
	}
	public void setCodebureauxregional(String codebureauxregional) {
		this.codebureauxregional = codebureauxregional;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTva() {
		return tva;
	}
	public void setTva(String tva) {
		this.tva = tva;
	}
	public String getRegistreDeCmmerce() {
		return registreDeCmmerce;
	}
	public void setRegistreDeCmmerce(String registreDeCmmerce) {
		this.registreDeCmmerce = registreDeCmmerce;
	}
	public String getEmployNumber() {
		return employNumber;
	}
	public void setEmployNumber(String employNumber) {
		this.employNumber = employNumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCodecentre() {
		return codecentre;
	}
	public void setCodecentre(String codecentre) {
		this.codecentre = codecentre;
	}
	public Clinique(String nom, String adress, String tva,
			String registreDeCmmerce, String employNumber, String tel,
			String codecentre, String codebureauxregional) {
		super();
		this.nom = nom;
		this.adress = adress;
		this.tva = tva;
		this.registreDeCmmerce = registreDeCmmerce;
		this.employNumber = employNumber;
		this.tel = tel;
		this.codecentre = codecentre;
		this.codebureauxregional = codebureauxregional;
	}


	
	
	

	

	
	
	

	
	

}
