package com.haythem.model;

import java.util.List;

public class BilanModel {

	/**
	 * 
	 */
	private Long id;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	private String generateur;
	private String Filtre;
	private String PoidsSec;
	private String UFTDuree;
	private String DebutDeDialyse;
	private String poidsDebut;
	private String priseDePoids ;
	private Tensionarterielle tensionarterielleDebut ;
	private String FinDeDialyse;
	private String poidsFin;
	private String perteDePoids ;
	private Tensionarterielle tensionarterielleFin ;
	private Boolean  heparine ;
	private String  Traitement ;
	private String infirmierName;
	private Long seanceId;
	private String  observationMedicales ;
	private String  UFT ;
	private String  options ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGenerateur() {
		return generateur;
	}
	public void setGenerateur(String generateur) {
		this.generateur = generateur;
	}
	public String getFiltre() {
		return Filtre;
	}
	public void setFiltre(String filtre) {
		Filtre = filtre;
	}
	public String getPoidsSec() {
		return PoidsSec;
	}
	public void setPoidsSec(String poidsSec) {
		PoidsSec = poidsSec;
	}
	public String getUFTDuree() {
		return UFTDuree;
	}
	public void setUFTDuree(String uFTDuree) {
		UFTDuree = uFTDuree;
	}
	public String getDebutDeDialyse() {
		return DebutDeDialyse;
	}
	public void setDebutDeDialyse(String debutDeDialyse) {
		DebutDeDialyse = debutDeDialyse;
	}
	public String getPoidsDebut() {
		return poidsDebut;
	}
	public void setPoidsDebut(String poidsDebut) {
		this.poidsDebut = poidsDebut;
	}
	public String getPriseDePoids() {
		return priseDePoids;
	}
	public void setPriseDePoids(String priseDePoids) {
		this.priseDePoids = priseDePoids;
	}
	
	public String getFinDeDialyse() {
		return FinDeDialyse;
	}
	public void setFinDeDialyse(String finDeDialyse) {
		FinDeDialyse = finDeDialyse;
	}
	public String getPoidsFin() {
		return poidsFin;
	}
	public void setPoidsFin(String poidsFin) {
		this.poidsFin = poidsFin;
	}
	public String getPerteDePoids() {
		return perteDePoids;
	}
	public void setPerteDePoids(String perteDePoids) {
		this.perteDePoids = perteDePoids;
	}

	public Boolean getHeparine() {
		return heparine;
	}
	public void setHeparine(Boolean heparine) {
		this.heparine = heparine;
	}
	public String getTraitement() {
		return Traitement;
	}
	public void setTraitement(String traitement) {
		Traitement = traitement;
	}
	
	public Long getSeanceId() {
		return seanceId;
	}
	public void setSeanceId(Long seanceId) {
		this.seanceId = seanceId;
	}
	public String getObservationMedicales() {
		return observationMedicales;
	}
	public void setObservationMedicales(String observationMedicales) {
		this.observationMedicales = observationMedicales;
	}
	public String getUFT() {
		return UFT;
	}
	public void setUFT(String uFT) {
		UFT = uFT;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}

	public BilanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tensionarterielle getTensionarterielleDebut() {
		return tensionarterielleDebut;
	}
	public void setTensionarterielleDebut(Tensionarterielle tensionarterielleDebut) {
		this.tensionarterielleDebut = tensionarterielleDebut;
	}
	public Tensionarterielle getTensionarterielleFin() {
		return tensionarterielleFin;
	}
	public void setTensionarterielleFin(Tensionarterielle tensionarterielleFin) {
		this.tensionarterielleFin = tensionarterielleFin;
	}
	public BilanModel(Long id, String generateur, String filtre, String poidsSec, String uFTDuree,
			String debutDeDialyse, String poidsDebut, String priseDePoids, Tensionarterielle tensionarterielleDebut,
			String finDeDialyse, String poidsFin, String perteDePoids, Tensionarterielle tensionarterielleFin,
			Boolean heparine, String traitement, String infirmierName, Long seanceId, String observationMedicales,
			String uFT, String options) {
		super();
		this.id = id;
		this.generateur = generateur;
		Filtre = filtre;
		PoidsSec = poidsSec;
		UFTDuree = uFTDuree;
		DebutDeDialyse = debutDeDialyse;
		this.poidsDebut = poidsDebut;
		this.priseDePoids = priseDePoids;
		this.tensionarterielleDebut = tensionarterielleDebut;
		FinDeDialyse = finDeDialyse;
		this.poidsFin = poidsFin;
		this.perteDePoids = perteDePoids;
		this.tensionarterielleFin = tensionarterielleFin;
		this.heparine = heparine;
		Traitement = traitement;
		this.infirmierName = infirmierName;
		this.seanceId = seanceId;
		this.observationMedicales = observationMedicales;
		UFT = uFT;
		this.options = options;
	}
	public String getInfirmierName() {
		return infirmierName;
	}
	public void setInfirmierName(String infirmierName) {
		this.infirmierName = infirmierName;
	}
	
	
}
