package com.qa.dfespringboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfespringboot.entities.Customer;

//jpaRepository (jpa=Java Persistence API) (API=Application Programming Interface) 
//requires Entity and datatype inside < > long=Long int=Integer
//repo is not a class but interface
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
