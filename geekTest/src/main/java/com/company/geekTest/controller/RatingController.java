package com.company.geekTest.controller;


import com.company.geekTest.model.*;
import com.company.geekTest.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    RatingRepository repository;


    @GetMapping("/ratings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Rating> getAllRatings() {
        return repository.findAll();
    }
    @PostMapping( "/ratings")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRating(@RequestBody Rating rating) {
        repository.save(rating);
    }

    @DeleteMapping("/ratings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable int id) {
        repository.deleteById(id);
    }

    /*@GetMapping( "/ratings/book/{book_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Rating>> getRatingByBook(@PathVariable int book_id) {
        List<Rating> ratings = repository.findByBook_book_id(book_id);

        if(ratings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ratings, HttpStatus.ACCEPTED);
        }

    }*/


}
