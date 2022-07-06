package com.qa.dfespringboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringboot.entities.Customer;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private List<Customer> customers = new ArrayList<>();
	
	@GetMapping("/test") //localhost:8080/customer/test
	public String test() {
		return "Hello, World!";
}
	
	@PostMapping("/create") //localhost:8080/customer/create
	public Customer create(@RequestBody Customer customer) {
		this.customers.add(customer);
		
		return this.customers.get(this.customers.size() - 1);
	}
	
	

}
