package fr.diginamic.banque.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="banque",  cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private Set<Client> clients = new HashSet<>();

	/**
	 * 
	 */
	public Banque() {
		clients = new HashSet<Client>();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the clients
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
	
	public void addClient(Client client){
		clients.add(client);
	}
	
	public void removeClient(Client client){
		clients.remove(client);
	}
}
