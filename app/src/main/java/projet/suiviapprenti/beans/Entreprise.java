package projet.suiviapprenti.beans;
// Generated 23 f�vr. 2016 13:46:09 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonView;

import projet.suiviapprenti.JSON.JSONViews;


/**
 * Entreprise generated by hbm2java
 */

public class Entreprise implements java.io.Serializable {

	@JsonView(JSONViews.AutocompleteEntreprise.class) private Integer identreprise;
	@JsonView(JSONViews.AutocompleteEntreprise.class) private Coordonnees coordonnees;
	@JsonView(JSONViews.AutocompleteEntreprise.class) private String nomEntreprise;
	@JsonView(JSONViews.AutocompleteEntreprise.class) private String branche;
	@JsonView(JSONViews.AutocompleteEntreprise.class) private int nbSalaries;

	public Entreprise() {
	}

	public Entreprise(Coordonnees coordonnees, String nomEntreprise, String branche, int nbSalaries) {
		this.coordonnees = coordonnees;
		this.nomEntreprise = nomEntreprise;
		this.branche = branche;
		this.nbSalaries = nbSalaries;
	}

	public Entreprise(Coordonnees coordonnees, String nomEntreprise, String branche, int nbSalaries,
			Set<ParcoursPostBts> parcoursPostBtses, Set<Apprenti> apprentis) {
		this.coordonnees = coordonnees;
		this.nomEntreprise = nomEntreprise;
		this.branche = branche;
		this.nbSalaries = nbSalaries;
	}

	public Integer getIdentreprise() {
		return this.identreprise;
	}

	public void setIdentreprise(Integer identreprise) {
		this.identreprise = identreprise;
	}


	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public String getNomEntreprise() {
		return this.nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getBranche() {
		return this.branche;
	}

	public void setBranche(String branche) {
		this.branche = branche;
	}

	public int getNbSalaries() {
		return this.nbSalaries;
	}

	public void setNbSalaries(int nbSalaries) {
		this.nbSalaries = nbSalaries;
	}


}
