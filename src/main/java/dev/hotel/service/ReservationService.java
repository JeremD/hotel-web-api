package dev.hotel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	private ReservationRepository reservationRepository;

	/**
	 * Constructor
	 * 
	 * @param reservationRepository
	 */
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	/**
	 * Créer une réservation
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @param client
	 * @param chambres
	 * @return
	 */
	@Transactional
	public Reservation ajouter(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		return reservationRepository.save(new Reservation(dateDebut, dateFin, client, chambres));
	}

}
