package dev.hotel.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
@RequestMapping
public class ClientController {

	/** clientRepository */
	protected ClientRepository clientRepository;

	/**
	 * Constructor
	 * 
	 * @param clientRepository
	 */
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	// Lister les clients dans une page
	@GetMapping("/clients")
	public ResponseEntity<?> listerClient(@RequestParam("start") Integer start, @RequestParam("size") Integer size) {

		// Retourner une erreur si paramètres incorrects
		if (size == null || start == null || start < 0 || size <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request error!");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(clientRepository.findAll(PageRequest.of(start, size)).toList());
	}

	// Lister un client selon l'uuid avec une page
	@GetMapping("/clients/{uuid}")
	public ResponseEntity<?> listerClientUUID(@PathVariable String uuid) {

		Optional<Client> findClient = clientRepository.findByUuid(UUID.fromString(uuid));

		// Retourner une erreur si paramètres incorrects
		if (uuid == null || !uuid.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect request!");
		} 
		
		// Retourner une erreur si client non trouvé
		else if (findClient.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found!");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(findClient);
	}

}
