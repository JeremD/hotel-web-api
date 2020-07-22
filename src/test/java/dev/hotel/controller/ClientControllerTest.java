package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ClientService clientService;

	@Test
	void listerClientTest() throws Exception {

		// Ajout de client
		Client addClient = new Client("GILBERT", "Paul");
		addClient.setUuid(UUID.fromString("9e9c730d-a357-4dd0-b027-c8e1b079664d"));

		Client addClient2 = new Client("CLEM", "Tom");
		addClient2.setUuid(UUID.fromString("de6df01a-8081-432a-a1ee-59687dc31e46"));

		// Stockage des clients dans une liste
		List<Client> listClient = new ArrayList<>();
		listClient.add(addClient);
		listClient.add(addClient2);

		// Liste des clients
		Mockito.when(clientService.lister(0, 5)).thenReturn(listClient);

		// Test Mockito (requête + réponse JSON)
		mockMvc.perform(MockMvcRequestBuilders.get("/clients").param("start", "0").param("size", "5"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").value("9e9c730d-a357-4dd0-b027-c8e1b079664d"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("GILBERT"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Paul"));
	}

	@Test
	void afficherClientParUuidTest() throws Exception {

		// Ajout de client
		Client addClient = new Client("TREV", "Martin");
		addClient.setUuid(UUID.fromString("f623d799-e1ec-4f8d-9c95-862a807b589e"));

		// Stockage du client dans un container optional
		Optional<Client> listClient = Optional.of(addClient);

		Mockito.when(clientService.afficher("f623d799-e1ec-4f8d-9c95-862a807b589e")).thenReturn(listClient);

		mockMvc.perform(MockMvcRequestBuilders.get("/clients/f623d799-e1ec-4f8d-9c95-862a807b589e"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value("f623d799-e1ec-4f8d-9c95-862a807b589e"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(addClient.getNom()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.prenoms").value(addClient.getPrenoms()));
	}

	@Test
	void ajouterClientTest() throws Exception {

		// Ajout de client
		Client addClient = new Client("BOB", "Dyl");
		addClient.setUuid(UUID.fromString("9c59df2e-16be-4348-8e7f-2a8e62bc4713"));

		Mockito.when(clientService.ajouter("BOB", "Dyl")).thenReturn(addClient);

		// JSON de test
		String testJson = "{ \"nom\": \"BOB\", \"prenoms\": \"Dyl\" }";

		mockMvc.perform(MockMvcRequestBuilders.post("/clients").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(testJson))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value("9c59df2e-16be-4348-8e7f-2a8e62bc4713"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(addClient.getNom()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.prenoms").value(addClient.getPrenoms()));
	}

}
