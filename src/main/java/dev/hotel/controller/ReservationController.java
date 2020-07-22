package dev.hotel.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.hotel.dto.CodeErreur;
import dev.hotel.dto.CreerReservationDto;
import dev.hotel.dto.MessageErreurDto;
import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Reservation;
import dev.hotel.service.ReservationService;

public class ReservationController {

	/** reservationService */
	protected ReservationService reservationService;

	/**
	 * Constructor
	 * 
	 * @param reservationService
	 */
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	// Créer une réservation
	@PostMapping("/reservations")
	public ResponseEntity<?> creerReservation(@Valid @RequestBody CreerReservationDto reservation, BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(new MessageErreurDto(CodeErreur.RESERVATION, "Error making reservation!"));
		}
		
		Reservation nouvelleReservation = reservationService.ajouter(reservation.getDateDebut(), reservation.getDateFin(), reservation.getClient(), reservation.getChambres());
		
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setDateDebut(nouvelleReservation.getDateDebut());
		reservationDto.setDateFin(nouvelleReservation.getDateFin());
		reservationDto.setClient(nouvelleReservation.getClient());
		reservationDto.setChambres(nouvelleReservation.getChambres());
		
		return ResponseEntity.ok(reservationDto);
		
	}
}
