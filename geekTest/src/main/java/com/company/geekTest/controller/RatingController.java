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
    public void deleteRatingById(@PathVariable int id) {
        repository.deleteById(id);
    }


    @GetMapping("/ratings/average/book/{book_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Double> getAverageRatingForBook(@PathVariable int book_id) {
        Double averageRating = repository.getAverageRatingForBook(book_id);


            return new ResponseEntity<>(averageRating, HttpStatus.ACCEPTED);


    }
}
