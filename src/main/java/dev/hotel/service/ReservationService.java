package dev.hotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.exceptions.ReservationException;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	/** reservationRepository */
	private ReservationRepository reservationRepository;
	
	/** chambreRepository */
	private ChambreRepository chambreRepository;

	/** clientService */
	protected ClientService clientService;
	
	/**
	 * Constructor
	 * 
	 * @param reservationRepository
	 */
	public ReservationService(ReservationRepository reservationRepository, ClientService clientService, ChambreRepository chambreRepository) {
		this.reservationRepository = reservationRepository;
		this.clientService = clientService;
		this.chambreRepository = chambreRepository;
	}

	/**
	 * Créer une réservation
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @param clientUuid
	 * @param chambresUuid
	 * @return
	 */
	@Transactional
	public Reservation ajouter(LocalDate dateDebut, LocalDate dateFin, UUID clientUuid, List<UUID> chambresUuid) {
		
		// Récupération de l'uuid client
		Client client = clientService.afficher(clientUuid).orElseThrow(
				() -> new ReservationException("uuid client non trouvé"));
		
		// Liste de chambres
		List<Chambre> listChambre = new ArrayList<>();
		
		// Ajout de chaque chambre
		for (UUID uuid : chambresUuid) {
			Chambre chambre = chambreRepository.findById(uuid).orElseThrow(
					() -> new ReservationException("la chambre n'existe pas"));
			listChambre.add(chambre);
		}
		
		return reservationRepository.save(new Reservation(dateDebut, dateFin, client, listChambre));
	}

}
