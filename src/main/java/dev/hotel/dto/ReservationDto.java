package dev.hotel.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;

public class ReservationDto {

	/** uuid */
	private UUID uuid;

	/** dateDebut */
	private LocalDate dateDebut;

	/** dateFin */
	private LocalDate dateFin;

	/** clientuuid */
	private Client client;

	/** chambres */
	private List<Chambre> chambres = new ArrayList<>();

	/**
	 * Constructor
	 * 
	 */
	public ReservationDto() {
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
	 * @return clientUuid
	 */
	public UUID getClient() {
		return client.getUuid();
	}

	/**
	 * Setter
	 * 
	 * @param client
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
