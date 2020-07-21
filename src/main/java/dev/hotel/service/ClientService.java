package dev.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	/**
	 * Constructor
	 * 
	 * @param clientRepository
	 */
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	// Lister les clients dans une page
	public List<Client> lister(Integer start, Integer size) {
		return clientRepository.findAll(PageRequest.of(start, size)).toList();
	}

	// Afficher un client selon son uuid
	public Optional<Client> afficher(String uuid) {
		return clientRepository.findById(UUID.fromString(uuid));
	}

	// Créer un nouveau client
	@Transactional
	public Client ajouter(String nom, String prenom) {
		return clientRepository.save(new Client(nom, prenom));
	}

}
