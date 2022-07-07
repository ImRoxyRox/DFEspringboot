package com.qa.dfespringboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.repos.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;

	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

//	POST=CREATE saveAndFlush saves immediately, save has delays
	public Customer create(Customer customer) {
		return this.repo.saveAndFlush(customer);

	}

// GET=READ readAll now use findAll
	public List<Customer> getAll() {
		return this.repo.findAll();
	}

//	GET=READ readById now use findById
	public Customer readById(long id) {
		return this.repo.findById(id).get();

	}

//  PUT=UPDATE
	public Customer update(long id, Customer customer) {
//		This gets the existing one
		Customer existing = this.repo.findById(id).get();

//		To change the existing one with the new customer object, check the notes 
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setEmail(customer.getEmail());

//		To save the entry back to the database
		return this.repo.saveAndFlush(existing);

	}

//  DELETE=DELETE
	public boolean delete(long id) {
		this.repo.deleteById(id);

//		Thsi should be false but with reverse should now be true to confirm deletion
		return !this.repo.existsById(id);
	}

}