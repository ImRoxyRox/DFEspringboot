package com.qa.dfespringboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringboot.entities.Customer;

//uses JSON data (Java Script Object Notation)
//Handle incoming http requests and send responses
@RestController
@RequestMapping("/customer")
public class CustomerController {

	// Temporary storage until we implement the real database later on
	private List<Customer> customers = new ArrayList<>();

//	// Use this only to check the connection with Postman
//	@GetMapping("/test") // localhost:8080/customer/test
//	public String test() {
//		return "Hello, World!";
//	}

	// GET=READ two reads available, ReadAll and ReadByID

	// ReadAll
	@GetMapping("/readAll")
	public List<Customer> readAll() {
		return this.customers;
	}

	// ReadByID only 1 not all
	@GetMapping("/readById/{id}") // in{} it will pick any id/number. Path and variable have to match.
	public Customer readById(@PathVariable int id) {
		return this.customers.get(id);
	}

	// Post=Create
	@PostMapping("/create") // localhost:8080/customer/create
	public Customer create(@RequestBody Customer customer) {
		this.customers.add(customer);

		// Returns the latest entry added to the list
		return this.customers.get(this.customers.size() - 1);
	}

// Put=Update
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable int id, @RequestBody Customer customer) {

		// Removing the original customer
		this.customers.remove(id);

		// Add the updated customer
		this.customers.add(id, customer);

		// Return the updated user
		return this.customers.get(id);
	}

	// Delete=Delete
	@DeleteMapping("/delete/{id}") 
	public Customer delete(@PathVariable int id) {
		return this.customers.remove(id);
	}
}

