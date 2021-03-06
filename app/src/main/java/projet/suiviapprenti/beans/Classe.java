package projet.suiviapprenti.beans;
// Generated 23 f�vr. 2016 13:46:09 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonView;

import projet.suiviapprenti.JSON.JSONViews;


/**
 * Classe generated by hbm2java
 */

public class Classe implements java.io.Serializable {

	private Integer idclasse;
	@JsonView(JSONViews.InfoProfil.class)	private String nom;
	@JsonView(JSONViews.InfoProfil.class)	private int annee;
	private Set<Apprenti> apprentis = new HashSet<Apprenti>(0);

	public Classe() {
	}

	public Classe(String nom, int annee) {
		this.nom = nom;
		this.annee = annee;
	}

	public Classe(String nom, int annee, Set<Apprenti> apprentis) {
		this.nom = nom;
		this.annee = annee;
		this.apprentis = apprentis;
	}

	public Integer getIdclasse() {
		return this.idclasse;
	}

	public void setIdclasse(Integer idclasse) {
		this.idclasse = idclasse;
	}


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Set<Apprenti> getApprentis() {
		return this.apprentis;
	}

	public void setApprentis(Set<Apprenti> apprentis) {
		this.apprentis = apprentis;
	}

}
