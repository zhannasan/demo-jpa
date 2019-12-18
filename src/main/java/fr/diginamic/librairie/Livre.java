package fr.diginamic.librairie;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
	@Id
	private int id;

	@Column(name = "titre", length = 255)
	private String titre;

	@Column(name = "auteur", length = 50)
	private String auteur;

	/**
	 * 
	 */
	public Livre() {
	}
	
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="ID_Liv", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="ID_Emp", referencedColumnName="ID")
	)
	private Set<Emprunt> emprunt;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur
	 *            the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
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
