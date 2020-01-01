package fr.diginamic.librairie;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientL")
public class ClientL {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@OneToMany(mappedBy="clientL")
	private Set<Emprunt> emprunt;
	
	
	/**
	 * 
	 */
	public ClientL() {
		emprunt = new HashSet<Emprunt>();
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the emprunt
	 */
	public Set<Emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(Set<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}

}
