package fr.diginamic.banque.entites;

import javax.persistence.Embeddable;

/**
 * Adresse postale du client (Client) avec des paramètres : numero (int) - numéro de
 * la rue; rue (String) - rue codePostal - code postal, ville (String) - ville
 * Embeddable dans Client.
 * @author janka
 * 
 */
@Embeddable
public class Adresse {
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	public Adresse(){
		
	}
	/**
	 * Constructeur Adresse avec des paramètres :
	 * @param numero - numéro de la rue
	 * @param rue - rue
	 * @param codePostal - code postal
	 * @param ville - ville
	 */
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
}