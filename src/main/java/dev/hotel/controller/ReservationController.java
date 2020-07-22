package dev.hotel.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.dto.CodeErreur;
import dev.hotel.dto.CreerReservationDto;
import dev.hotel.dto.MessageErreurDto;
import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.exceptions.ReservationException;
import dev.hotel.service.ClientService;
import dev.hotel.service.ReservationService;

@RestController
@RequestMapping
public class ReservationController {

	/** reservationService */
	protected ReservationService reservationService;

	/** clientService */
	protected ClientService clientService;
	
	/**
	 * Constructor
	 * 
	 * @param reservationService
	 */
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<String> onReservationException(ReservationException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	// Créer une réservation
	@PostMapping("/reservations")
	public ResponseEntity<?> creerReservation(@Valid @RequestBody CreerReservationDto reservation, BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(new MessageErreurDto(CodeErreur.RESERVATION, "Error making reservation!"));
		}
		
		// Création d'une réservation
		Reservation nouvelleReservation = reservationService.ajouter(reservation.getDateDebut(), reservation.getDateFin(), reservation.getClientUuid(), reservation.getChambres());
		
		// Transformation DTO
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setUuid(nouvelleReservation.getUuid());
		reservationDto.setDateDebut(nouvelleReservation.getDateDebut());
		reservationDto.setDateFin(nouvelleReservation.getDateFin());
		reservationDto.setClient(nouvelleReservation.getClient());
		reservationDto.setChambres(nouvelleReservation.getChambres());
		
		return ResponseEntity.ok(reservationDto);
		
	}
}
