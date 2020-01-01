package fr.diginamic.librairie;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	private int id;
	
	@Column(name="date_debut")
	private LocalDate dateDebut;
	
	@Column(name="delai", length=10)
	private int delai;
	
	@Column(name="date_fin")
	private LocalDate dateFin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ClientL")
	private ClientL client;
	
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="ID_Emp", referencedColumnName="ID"),
			inverseJoinColumns = @JoinColumn(name="ID_Liv", referencedColumnName="ID")
	)
	private Set<Livre> livres;

	/**
	 * 
	 */
	public Emprunt() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the client
	 */
	public ClientL getClientL() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClientL(ClientL client) {
		this.client = client;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	
}
