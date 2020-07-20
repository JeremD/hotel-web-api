package dev.hotel.entite;

import javax.persistence.Entity;

@Entity
// BaseEntite pour générer l'UUID
public class Client extends BaseEntite {

	/** nom */
	private String nom;

	/** prenoms */
	private String prenoms;

	/**
	 * Constructor
	 * 
	 */
	public Client() {
	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prenoms
	 */
	public Client(String nom, String prenoms) {
		this.nom = nom;
		this.prenoms = prenoms;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
}
