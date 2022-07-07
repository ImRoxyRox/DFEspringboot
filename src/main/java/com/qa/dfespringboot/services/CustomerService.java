package com.qa.dfespringboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringboot.entities.Customer;

@Service
public class CustomerService {

	private List<Customer> customers = new ArrayList<>();

//	POST=CREATE 
	public Customer create(Customer customer) {
		this.customers.add(customer);
		return this.customers.get(this.customers.size() - 1);

	}

// GET=READ readAll
	public List<Customer> getAll() {
		return this.customers;
	}

//	GET=READ readById
	public Customer readById(int id) {
		return this.customers.get(id);
	}

//  PUT=UPDATE
	public Customer update(int id, Customer customer) {
		this.customers.remove(id);
		this.customers.add(id, customer);
		return this.customers.get(id);

	}

//  DELETE=DELETE
	public Customer delete(int id) {
		return this.customers.remove(id);
	}

}


