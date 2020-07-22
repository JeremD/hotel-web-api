package dev.hotel.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreerClientDto {

	/** nom */
	@NotNull
	@Size(min = 2)
	@NotBlank
	@JsonProperty("nom")
	private String nom;

	/** prenoms */
	@NotNull
	@Size(min = 2)
	@NotBlank
	@JsonProperty("prenoms")
	private String prenoms;

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

}
