package dev.hotel.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientControleur {

	/** clientRepository */
	private ClientRepository clientRepository;

	/**
	 * Constructor
	 * 
	 * @param clientRepository
	 */
	public ClientControleur(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	// Liste des clients
	@GetMapping
	public List<Client> listerClient(@RequestParam("start") int start, @RequestParam("size") int size) {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}
}
