package com.company.geekTest.controller;

import com.company.geekTest.model.Customer;
import com.company.geekTest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    //Get user by username
    @GetMapping("/customers/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerByUsername(@PathVariable String username) {
        Customer customer = repository.findByUsername(username);
        if (customer == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer not found"
            );
        }
        return customer;
    }

    //Update customer by Username
    @PatchMapping("/customers/username/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerByUsername(@PathVariable String username, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = repository.findByUsername(username);

        if (existingCustomer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }


        if (updatedCustomer.getUsername() != null) existingCustomer.setUsername(updatedCustomer.getUsername());
        if (updatedCustomer.getUser_password() != null) existingCustomer.setUser_password(updatedCustomer.getUser_password());
        if (updatedCustomer.getUser_first_name() != null) existingCustomer.setUser_first_name(updatedCustomer.getUser_first_name());
        if (updatedCustomer.getUser_last_name() != null) existingCustomer.setUser_last_name(updatedCustomer.getUser_last_name());
        if (updatedCustomer.getAddress() != null) existingCustomer.setAddress(updatedCustomer.getAddress());
        if (updatedCustomer.getCredit_card() != null) existingCustomer.setCredit_card(updatedCustomer.getCredit_card());

        repository.save(existingCustomer);
    }

    //Create credit card
    @PostMapping("/customers/username/{username}/creditcard")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCreditCardToUser(@PathVariable String username, @RequestBody String creditCard) {
        Customer customer = repository.findByUsername(username);
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        customer.setCredit_card(creditCard);
        repository.save(customer);
    }



}