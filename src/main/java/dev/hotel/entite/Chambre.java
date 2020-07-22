package dev.hotel.entite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Chambre extends BaseEntite {

	/** numero */
	private String numero;

	/** surface */
	private Float surface;

	/** hotel */
	@ManyToOne
	private Hotel hotel;

	/**
	 * Constructor
	 * 
	 */
	public Chambre() {
	}

	/**
	 * Constructor
	 * 
	 * @param numero
	 * @param surface
	 * @param hotel
	 */
	public Chambre(String numero, Float surface, Hotel hotel) {
		this.numero = numero;
		this.surface = surface;
		this.hotel = hotel;
	}

	/**
	 * @return
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return
	 */
	public Float getSurface() {
		return surface;
	}

	/**
	 * @param surfaceEnM2
	 */
	public void setSurface(Float surfaceEnM2) {
		this.surface = surfaceEnM2;
	}
}
