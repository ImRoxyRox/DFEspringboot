package com.qa.dfespringboot.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfespringboot.entities.Customer;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc; // to sent mock requests

	@Autowired
	private ObjectMapper mapper; // to convert objects to JSON

	@Test
	public void readAllTest() throws Exception {
		// to set up expected output object
		List<Customer> output = new ArrayList<>();
		Customer entry = new Customer(1L, "Roxy", "Ortu", "roxy@gmail.com");
		output.add(entry);
		// to convert the expected output to JSON
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/customer/readAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
	}

}