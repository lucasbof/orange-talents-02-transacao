package br.com.zup.cardTransaction.transaction;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@WithMockUser
class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Deveria buscar as transações e retornar 200 pelo número do cartão caso exista")
	void test1() throws Exception {
		mockMvc
			.perform(get("/transactions/buys/{cardNumber}", "0000-0000-0000-0000")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deveria retornar 404 caso o número do cartão não exista")
	void test2() throws Exception {
		mockMvc
			.perform(get("/transactions/buys/{cardNumber}", "989")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

}
