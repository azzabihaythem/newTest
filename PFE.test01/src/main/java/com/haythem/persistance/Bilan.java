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
	private String filtre;
	
	@Column(name = "POIDSSEC")
	private String poidsSec;
	
	@Column(name = "UFT_DUREE")
	private String uftDuree;
	
	@Column(name = "DEBUT_DE_DIALYSE")
	private String debutDeDialyse;
	
	@Column(name = "POIDS_DEBUT")
	private String poidsDebut;
	
	@Column(name = "PRISE_DE_POIDS")
	private String priseDePoids ;
	
	@Column(name = "TENSION_ARTERIELLE_DEBUT_S")
	private String tensionarterielleDebutSystolique ;
	
	@Column(name = "TENSION_ARTERIELLE_DEBUT_D")
	private String tensionarterielleDebutDiastolique ;
	
	@Column(name = "FIN_DE_DIALYSE")
	private String finDeDialyse;
	
	@Column(name = "POIDS_Fin")
	private String poidsFin;
	
	@Column(name = "PERTE_DE_POIDS")
	private String perteDePoids ;
	
	@Column(name = "TENSION_ARTERIELLE_FIN_S")
	private String tensionarterielleFinSystolique ;
	
	@Column(name = "TENSION_ARTERIELLE_FIN_D")
	private String tensionarterielleFinDiastolique;
	
	@Column(name = "HEPARINE")
	private Boolean  heparine ;
	
	@Column(name = "TRAITEMENT")
	private String  traitement ;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "INFIRMIER")
	private User infirmier;

	@ManyToOne(optional = true)
	@JoinColumn(name = "SEANCE")
	private Seance seance;
	
	@Column(name = "OBSERVATION_MEDICALES")
	private String  observationMedicales ;
	
	@Column(name = "UFT")
	private String  uft ;

	@Column(name = "OPTIONS")
	private String  options ;
	
	

	


	public String getGenerateur() {
		return generateur;
	}



	public void setGenerateur(String generateur) {
		this.generateur = generateur;
	}



	public String getFiltre() {
		return filtre;
	}



	public void setFiltre(String filtre) {
		this.filtre = filtre;
	}



	public String getPoidsSec() {
		return poidsSec;
	}



	public void setPoidsSec(String poidsSec) {
		this.poidsSec = poidsSec;
	}






	public String getUftDuree() {
		return uftDuree;
	}



	public void setUftDuree(String uftDuree) {
		this.uftDuree = uftDuree;
	}



	public String getDebutDeDialyse() {
		return debutDeDialyse;
	}



	public void setDebutDeDialyse(String debutDeDialyse) {
		this.debutDeDialyse = debutDeDialyse;
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
		return finDeDialyse;
	}



	public void setFinDeDialyse(String finDeDialyse) {
		this.finDeDialyse = finDeDialyse;
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






	public String getTensionarterielleDebutSystolique() {
		return tensionarterielleDebutSystolique;
	}



	public void setTensionarterielleDebutSystolique(String tensionarterielleDebutSystolique) {
		this.tensionarterielleDebutSystolique = tensionarterielleDebutSystolique;
	}



	public String getTensionarterielleDebutDiastolique() {
		return tensionarterielleDebutDiastolique;
	}



	public Bilan(String generateur, String filtre, String poidsSec, String uftDuree, String debutDeDialyse,
			String poidsDebut, String priseDePoids, String tensionarterielleDebutSystolique,
			String tensionarterielleDebutDiastolique, String finDeDialyse, String poidsFin, String perteDePoids,
			String tensionarterielleFinSystolique, String tensionarterielleFinDiastolique, Boolean heparine,
			String traitement, User infirmier, Seance seance, String observationMedicales, String uft, String options) {
		super();
		this.generateur = generateur;
		this.filtre = filtre;
		this.poidsSec = poidsSec;
		this.uftDuree = uftDuree;
		this.debutDeDialyse = debutDeDialyse;
		this.poidsDebut = poidsDebut;
		this.priseDePoids = priseDePoids;
		this.tensionarterielleDebutSystolique = tensionarterielleDebutSystolique;
		this.tensionarterielleDebutDiastolique = tensionarterielleDebutDiastolique;
		this.finDeDialyse = finDeDialyse;
		this.poidsFin = poidsFin;
		this.perteDePoids = perteDePoids;
		this.tensionarterielleFinSystolique = tensionarterielleFinSystolique;
		this.tensionarterielleFinDiastolique = tensionarterielleFinDiastolique;
		this.heparine = heparine;
		this.traitement = traitement;
		this.infirmier = infirmier;
		this.seance = seance;
		this.observationMedicales = observationMedicales;
		this.uft = uft;
		this.options = options;
	}



	public void setTensionarterielleDebutDiastolique(String tensionarterielleDebutDiastolique) {
		this.tensionarterielleDebutDiastolique = tensionarterielleDebutDiastolique;
	}



	public String getTensionarterielleFinSystolique() {
		return tensionarterielleFinSystolique;
	}



	public void setTensionarterielleFinSystolique(String tensionarterielleFinSystolique) {
		this.tensionarterielleFinSystolique = tensionarterielleFinSystolique;
	}



	public String getTensionarterielleFinDiastolique() {
		return tensionarterielleFinDiastolique;
	}



	public void setTensionarterielleFinDiastolique(String tensionarterielleFinDiastolique) {
		this.tensionarterielleFinDiastolique = tensionarterielleFinDiastolique;
	}



	public Boolean getHeparine() {
		return heparine;
	}



	public void setHeparine(Boolean heparine) {
		this.heparine = heparine;
	}



	public String getTraitement() {
		return traitement;
	}



	public void setTraitement(String traitement) {
		this.traitement = traitement;
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







	public String getUft() {
		return uft;
	}



	public void setUft(String uft) {
		this.uft = uft;
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
