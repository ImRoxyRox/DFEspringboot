package com.qa.dfespringboot.controllers;

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
import com.qa.dfespringboot.services.CustomerService;

//Handle incoming http requests and send responses
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService service;

//	creates dependency with CustomerService class
	public CustomerController(CustomerService service) {
		this.service = service;
	}

//	POST=CREATE localhost:8080/customer/create
	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		return this.service.create(customer);

	}

//	GET=READ readAll localhost:8080/customer/readAll
	@GetMapping("/readAll")
	public List<Customer> readAll() {
		return this.service.getAll();
	}

//	GET=READ readById localhost:8080/customer/readById/
	@GetMapping("/readById/{id}") // in{} it will pick any id/number. Path and variable have to match.
	public Customer readById(@PathVariable long id) {
		return this.service.readById(id);
	}

//	PUT=UPDATE localhost:8080/customer/update
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
		return this.service.update(id, customer);

	}
//  Changed to boolean to return true of false to match CustomerService
// 	Delete=Delete localhost:8080/customer/delete/
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
}

