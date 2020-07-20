package dev.hotel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;

// UUID généré automatiquement
public interface ClientRepository extends JpaRepository <Client, UUID> {

	List<Client> findAll();
}
