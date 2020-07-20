package dev.hotel.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
	void listerClient() throws Exception {
		
		// Insertion des données
		Client addClient = new Client("GILBERT", "Paul");
		
		// Génération d'un UUID
		addClient.setUuid(addClient.getUuid());
	
		// Liste des clients avec Page
		List<Client> getClient = clientRepository.findAll(PageRequest.of(0,2,Sort.by("nom").ascending())).toList();

		assertThat(getClient).extracting(Client::getNom).contains("GILBERT");
		
		// Test Mockito
		mockMvc.perform(MockMvcRequestBuilders.get("/client"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Odd"));
	}

}
