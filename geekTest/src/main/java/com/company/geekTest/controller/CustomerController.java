package com.company.geekTest.controller;

import com.company.geekTest.model.Customer;
import com.company.geekTest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    CustomerRepository repository;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable int id) {
        repository.deleteById(id);
    }



}