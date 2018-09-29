package com.haythem.persistance;


//seance
//-----------------------------
//-Generateur                 -Poids sec
//-Filtre                     -Infirmier (e) user
//                            -UFT/Duree
//----------------------------------
//-Debut de dialyse          -Fin de ndialyse	
//-Poids                     -Poids
//-Prise de Poids            -Perte Poids
//Tension arterielle(couche) -Tension	arterielle (couche)		
//----------------------------------	 
//-Heparine                   -Traitement

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
@Table(name = "BILAN")
public class Bilan extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "GENERATEUR")
	private String generateur;
	@Column(name = "FILTRE")
	private String Filtre;
	@Column(name = "POIDSSEC")
	private String PoidsSec;
	@Column(name = "UFT_DUREE")
	private String UFTDuree;
	@Column(name = "DEBUT_DE_DIALYSE")
	private String DebutDeDialyse;
	@Column(name = "POIDS_DEBUT")
	private String poidsDebut;
	@Column(name = "PRISE_DE_POIDS")
	private String priseDePoids ;
	@Column(name = "TENSION_ARTERIELLE_DEBUT")
	private String TensionarterielleDebut ;
	@Column(name = "FIN_DE_DIALYSE")
	private String FinDeDialyse;
	@Column(name = "POIDS_Fin")
	private String poidsFin;
	@Column(name = "PERTE_DE_POIDS")
	private String perteDePoids ;
	@Column(name = "TENSION_ARTERIELLE_FIN")
	private String TensionarterielleFin ;
	@Column(name = "HEPARINE")
	private Boolean  heparine ;
	@Column(name = "TRAITEMENT")
	private String  Traitement ;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "INFIRMIER")
	private User infirmier;

	@ManyToOne(optional = true)
	@JoinColumn(name = "SEANCE")
	private Seance seance;
	
	@Column(name = "OBSERVATION_MEDICALES")
	private String  observationMedicales ;
	
	@Column(name = "UFT")
	private String  UFT ;

	@Column(name = "OPTIONS")
	private String  options ;
	
	
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


	public String getTensionarterielleDebut() {
		return TensionarterielleDebut;
	}


	public void setTensionarterielleDebut(String tensionarterielleDebut) {
		TensionarterielleDebut = tensionarterielleDebut;
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


	public String getTensionarterielleFin() {
		return TensionarterielleFin;
	}


	public void setTensionarterielleFin(String tensionarterielleFin) {
		TensionarterielleFin = tensionarterielleFin;
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


	public User getInfirmier() {
		return infirmier;
	}


	public void setInfirmier(User infirmier) {
		this.infirmier = infirmier;
	}


	public Seance getSeance() {
		return seance;
	}


	public void setSeance(Seance seance) {
		this.seance = seance;
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


	public Bilan() {
	}
	
}
