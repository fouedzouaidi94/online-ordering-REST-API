package com.example.customerproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customerproject.Entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}