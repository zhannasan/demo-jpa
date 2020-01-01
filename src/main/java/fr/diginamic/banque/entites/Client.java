package fr.diginamic.banque.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Une classe qui représente un Client avec des paramètres:
 * id (int) - une valeur auto-générée;
 * nom (String) - nom d'un client;
 * prenom (String) - prénom d'un client;
 * dateNaissance (LocalDate) - date de naissance d'un client;
 * adresse (Adresse) - embedded adresse d'un client;
 * Définit une rélation Many-to-One avec une banque (Banque) et
 * une rélation Many-to-Many avec une compte (Comptes).
 * Contient un constructeur sans paramètres, getters et setters appropriés.
 * @author janka
 *
 */
@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;

	@Column(name = "date_naissance")
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_banque", referencedColumnName="ID")
	private Banque banque;

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "compo", 
		joinColumns = @JoinColumn(name = "ID_client", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "ID_compte", referencedColumnName = "id"))
	private Set<Compte> comptes = new HashSet<>();


	/**
	 * Constructeur Client sans paramètres
	 */
	public Client() {
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
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance =dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
