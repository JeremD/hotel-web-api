package dev.hotel.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;

public class CreerReservationDto {

	/** dateDebut */
	@NotNull
	@NotBlank
	@JsonFormat(pattern = "YYYY-MM-dd")
	@JsonProperty("dateDebut")
	private LocalDate dateDebut;

	/** dateFin */
	@NotNull
	@NotBlank
	@JsonFormat(pattern = "YYYY-MM-dd")
	@JsonProperty("dateFin")
	private LocalDate dateFin;

	/** clientUuid */
	@NotNull
	@NotBlank
	@JsonProperty("clientId")
	private Client client;

	@NotNull
	@NotBlank
	@JsonProperty("chambres")
	private List<Chambre> chambres = new ArrayList<>();

	/**
	 * Getter
	 * 
	 * @return dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter
	 * 
	 * @param client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter
	 * 
	 * @return chambres
	 */
	public List<Chambre> getChambres() {
		return chambres;
	}

	/**
	 * Setter
	 * 
	 * @param chambres to set
	 */
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

}
