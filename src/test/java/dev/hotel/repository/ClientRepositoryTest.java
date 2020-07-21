package dev.hotel.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

import org.springframework.data.domain.Sort;

import dev.hotel.controller.ClientController;
import dev.hotel.entite.Client;

@WebMvcTest(ClientController.class)
public class ClientRepositoryTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClientRepository clientRepository;

	@Test
	void listerClientTest() throws Exception {

		// Ajout de client
		Client addClient = new Client("GILBERT", "Paul");
		addClient.setUuid(UUID.fromString("9e9c730d-a357-4dd0-b027-c8e1b079664d"));

		// Stockage des clients dans une liste
		List<Client> listClient = new ArrayList<>();
		listClient.add(addClient);
		
		// Création d'une page de liste de client
		Page<Client> pageClient = new PageImpl<>(listClient);

		// Liste des clients avec la page
		Mockito.when(clientRepository.findAll(PageRequest.of(0, 5))).thenReturn(pageClient);

		// Test Mockito (requête + réponse JSON)
		mockMvc.perform(MockMvcRequestBuilders.get("/clients").param("start", "10").param("size", "10"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").value("9e9c730d-a357-4dd0-b027-c8e1b079664d"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("GILBERT"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Paul"));
	}

}
