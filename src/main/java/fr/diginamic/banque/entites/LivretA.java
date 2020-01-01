package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Une classe qui représente un compte banquaire de type LivretA (hérite de
 * Compte) avec des paramètres du Compte et taux (double)
 * - taux du LivretA. Contient un constructeur sans paramètres, un constructeur
 * avec un paramètre taux, getters et setters appropriés.
 * 
 * @author janka
 */
@Entity(name = "LivretA")
@DiscriminatorValue("LA")
public class LivretA extends Compte {
	@Column(name = "taux")
	private double taux;

	/**
	 * Constructeur sans paramètres
	 */
	public LivretA() {
		super();
	}

	/**
	 * @param taux
	 *            - taux de compte type LivretA
	 */
	public LivretA(double taux) {
		super();
		this.taux = taux;
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
