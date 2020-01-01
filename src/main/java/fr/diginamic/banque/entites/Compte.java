package fr.diginamic.banque.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

/**
 * Une classe qui représente comptes banquaires avec des paramètres: id (int) -
 * une valeur auto-générée; numero (int) - numéro de compte; solde (double) -
 * solde de compte. Définit une relation Many-to-Many avec un client (Client).
 * Contient un constructeur sans paramètres, getters et setters appropriés.
 * 
 * @author janka
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@NaturalId
	@Column(name = "numero", unique = true, nullable = false)
	private int numero;

	@Column(name = "solde")
	private double solde;

	/**
	 * Constructeur Compte sans paramètres
	 */
	public Compte() {
	}

	/**
	 * Relation avec Client: Many-to-many
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "comptes")
	private Set<Client> clients = new HashSet<>();

	/**
	 * @return Set de clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the numero de compte
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero de compte to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde de compte
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde de compte to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Compte compte = (Compte) o;
		return Objects.equals(numero, compte.numero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
}
