package dev.hotel.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

	List<Client> findAll();

	// UUID => ID de la base
	@Query("select c from Client c where c.uuid = ?1")
	Optional<Client> findByUuid(UUID uuid);

}
