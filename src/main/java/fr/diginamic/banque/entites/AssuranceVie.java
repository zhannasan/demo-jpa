package fr.diginamic.banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Une classe qui représente un compte banquaire de type AssuranceVie (hérite de
 * Compte) avec des paramètresdes paramètres du Compte, taux (double) - taux de
 * l'AssuranceVie; dateFin (localDate) - date fin de l'assurance de vie.
 * Contient un constructeur sans paramètres, un constructeur avec deux
 * paramètres dateFin et taux, getters et setters appropriés.
 * 
 * @author janka
 */
@Entity(name = "AssuranceVie")
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte {
	@Column(name = "dateFin")
	private LocalDate dateFin;
	@Column(name = "taux")
	private double taux;

	/**
	 * Constructeur sans paramètres
	 */
	public AssuranceVie() {
		super();
	}

	/**
	 * Constructeur avec des paramètres
	 * 
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(LocalDate dateFin, double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
