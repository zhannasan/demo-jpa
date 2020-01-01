package fr.diginamic.banque.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Une classe abstraite qui représene une Operation banquaire avec des
 * paramètres: id (int) - une valeur auto-générée; date (LocalDate) - date de
 * virement; montant (double) - montant de virement; motif (Sting) - motif de
 * virement. Définit une relation Many-to-One avec un compte (Compte) via
 * NaturalId numero . Contient un constructeur sans paramètres, getters et
 * setters appropriés.
 * 
 * @author janka
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "date")
	private LocalDate date;
	@Column(name = "montant")
	private double montant;
	@Column(name = "motif")
	private String motif;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Compte.class)
	@JoinColumn(name = "numero", referencedColumnName = "numero")
	private Compte compte;

	/**
	 * Constructeur Operation sans paramètres
	 */
	public Operation() {
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif
	 *            the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param comptes
	 *            the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
