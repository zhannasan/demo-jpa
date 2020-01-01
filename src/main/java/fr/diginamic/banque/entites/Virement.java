package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Une classe qui représente une Opération banquaire de type Virement avec
 * paramètres: id (int) - une valeur auto-générée; beneficiaire (String) -
 * bénéficiaire d'une virement. Contient un constructeur sans paramètres, un
 * constructeur avec un paramètre bénéficiaire, getters et setters appropriés.
 * @author janka
 */
@Entity(name = "Virement")
@DiscriminatorValue("VR")
public class Virement extends Operation {
	@Column(name = "beneficiaire")
	private String beneficiaire;

	/**
	 * Constructeur Virement sans paramètres
	 */
	public Virement() {
	}

	/**
	 * Constructeur avec un paramètre
	 * 
	 * @param beneficiaire
	 *            - nom et préno, du bénéficiaire
	 */
	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire
	 *            the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
