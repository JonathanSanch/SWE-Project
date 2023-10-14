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

   /* @Autowired
    BookRepository bookRepository;*/

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    // Retrieve list of books associated with an author
    /*@GetMapping("/{author_id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Integer author_id) {
        List<Book> books = bookRepository.findByAuthorId(author_id);
        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }*/

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repository.save(author);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable Integer author_id) {
        repository.deleteById(author_id);
    }


}
