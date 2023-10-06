package com.company.geekTest.controller;


import com.company.geekTest.model.Author;
import com.company.geekTest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository repository;

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repository.save(author);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable int id) {
        repository.deleteById(id);
    }


}
