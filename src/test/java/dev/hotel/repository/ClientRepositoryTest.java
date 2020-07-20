package dev.hotel.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
		Client client = new Client("GILBERT", "Paul");
		
		
		// Test Mockito
		mockMvc.perform(MockMvcRequestBuilders.get("/client"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Odd"));
	}

}
