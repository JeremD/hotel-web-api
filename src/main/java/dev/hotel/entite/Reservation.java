package dev.hotel.entite;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation extends BaseEntite {

	/** dateDebut */
	private LocalDate dateDebut;

	/** dateFin */
	private LocalDate dateFin;

	/** client */
	@ManyToOne
	private Client client;

	/** chambres */
	@ManyToMany
	private List<Chambre> chambres = new ArrayList<>();

	/**
	 * Constructor
	 * 
	 */
	public Reservation() {
	}

	/**
	 * Constructor
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @param client
	 * @param chambres
	 */
	public Reservation(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.chambres = chambres;
	}

	/**
	 * @return
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return
	 */
	public List<Chambre> getChambres() {
		return chambres;
	}

	/**
	 * @param chambres
	 */
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
}
