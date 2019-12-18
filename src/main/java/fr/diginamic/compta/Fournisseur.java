package fr.diginamic.compta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
	@Id
	private Integer id;

	@Column(name = "Nom", length = 50)
	private String Nom;

	/**
	 * Constructeur Fournisseur sans parametres
	 * 
	 */
	public Fournisseur() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

}
