package dev.hotel.dto;

import java.util.UUID;

public class ClientDto {

	/** uuid */
	private UUID uuid;

	/** nom */
	private String nom;

	/** prenoms */
	private String prenoms;

	/**
	 * Constructor
	 * 
	 */
	public ClientDto() {
	}

	/**
	 * Getter
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * Setter
	 * 
	 * @param prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * Getter
	 * 
	 * @return uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * Setter
	 * 
	 * @param uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
