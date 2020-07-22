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

	/**
	 * Lister les clients dans une page
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<Client> lister(Integer start, Integer size) {
		return clientRepository.findAll(PageRequest.of(start, size)).toList();
	}

	/**
	 * Afficher un client selon son uuid
	 * 
	 * @param uuid
	 * @return
	 */
	public Optional<Client> afficher(UUID uuid) {
		return clientRepository.findById(uuid);
	}

	/**
	 * Créer un nouveau client
	 * 
	 * @param nom
	 * @param prenom
	 * @return
	 */
	@Transactional
	public Client ajouter(String nom, String prenom) {
		return clientRepository.save(new Client(nom, prenom));
	}

}
