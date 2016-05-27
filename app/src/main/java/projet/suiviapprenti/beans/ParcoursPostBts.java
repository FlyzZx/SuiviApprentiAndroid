package projet.suiviapprenti.beans;
// Generated 23 f�vr. 2016 13:46:09 by Hibernate Tools 4.3.1.Final

import java.util.Date;


/**
 * ParcoursPostBts generated by hbm2java
 */
public class ParcoursPostBts implements java.io.Serializable {

	private Integer idparcoursPostBts;
	private Apprenti apprenti;
	private Entreprise entreprise;
	private String fonction;
	private Date dateDebut;

	public ParcoursPostBts() {
	}

	public ParcoursPostBts(Apprenti apprenti, String fonction, Date dateDebut) {
		this.apprenti = apprenti;
		this.fonction = fonction;
		this.dateDebut = dateDebut;
	}

	public ParcoursPostBts(Apprenti apprenti, Entreprise entreprise, String fonction, Date dateDebut) {
		this.apprenti = apprenti;
		this.entreprise = entreprise;
		this.fonction = fonction;
		this.dateDebut = dateDebut;
	}


	public Integer getIdparcoursPostBts() {
		return this.idparcoursPostBts;
	}

	public void setIdparcoursPostBts(Integer idparcoursPostBts) {
		this.idparcoursPostBts = idparcoursPostBts;
	}

	public Apprenti getApprenti() {
		return this.apprenti;
	}

	public void setApprenti(Apprenti apprenti) {
		this.apprenti = apprenti;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

}
