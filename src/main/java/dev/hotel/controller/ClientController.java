package dev.hotel.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.dto.ClientDto;
import dev.hotel.dto.CodeErreur;
import dev.hotel.dto.CreerClientDto;
import dev.hotel.dto.MessageErreurDto;
import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;

@RestController
@RequestMapping
public class ClientController {

	/** clientRepository */
	protected ClientService clientService;

	/**
	 * Constructor
	 * 
	 * @param clientRepository
	 */
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	// Lister les clients dans une page
	@GetMapping("/clients")
	public ResponseEntity<?> listerClient(@RequestParam("start") Integer start, @RequestParam("size") Integer size) {

		// Retourne une erreur si paramètres incorrects
		if (size == null || start == null || start < 0 || size <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect request!");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(clientService.lister(start, size));
	}

	// Lister un client selon l'uuid avec une page
	@GetMapping("/clients/{uuid}")
	public ResponseEntity<?> listerClientUUID(@PathVariable String uuid) {

		// Retourner une erreur si paramètres incorrects
		if (uuid == null || !uuid.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect request!");
		}

		// Retourne une erreur si client non trouvé
		else if (clientService.afficher(uuid).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found!");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.afficher(uuid));
	}

	// Créer un client
	@PostMapping("/clients")
	public ResponseEntity<?> ajouterClient(@Valid @RequestBody CreerClientDto client, BindingResult result) {

		// Retourne une erreur de création de client
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(new MessageErreurDto(CodeErreur.CREATION, "Error creating client!"));
		}
		
		// Création d'un nouveau client
		Client nouveauClient = clientService.ajouter(client.getNom(), client.getPrenoms());
		
		// Transformation DTO
		ClientDto clientDto = new ClientDto();
		clientDto.setUuid(nouveauClient.getUuid());
		clientDto.setNom(nouveauClient.getNom());
		clientDto.setPrenoms(nouveauClient.getPrenoms());
		
		return ResponseEntity.ok(clientDto);
		
	}

}
