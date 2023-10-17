package com.company.geekTest.controller;

import com.company.geekTest.model.Author;
import com.company.geekTest.model.Book;
/*import com.company.geekTest.model.Customer;*/
import com.company.geekTest.repository.AuthorRepository;
import com.company.geekTest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;




    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }


    //Retrieve books by genre
    @GetMapping("/books/genre/{genre}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooksByGenre(@PathVariable String genre){
        return repository.findByGenre(genre);
    }


    //get a list of the top 10 selling books
    @GetMapping("/books/topSellers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getTopSellers(){
        return repository.getTopSellers();
    }

    @GetMapping("/books/rating/{rating}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooksByRating(@PathVariable float rating){
        return repository.getBetterThanRating(rating);
    }


    // Retrieve a book's details by the ISBN
    @GetMapping("/books/isbn/{isbn}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBookByIsbn(@PathVariable String isbn) {
        List<Book> book = repository.findByIsbn(isbn);
        return book;
    }

    // Retrieve list of books associated with an author
    @GetMapping("/{author_id}/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooksByAuthorId(@PathVariable Integer author_id) {
        List<Book> books = repository.findByAuthorId(author_id);
        return books;
    }


    // Retrieve list of books associated with an author
    @GetMapping("/authors/{author_id}/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooksByAuthor(@PathVariable Integer author_id) {
        List<Book> books = repository.findByAuthorId(author_id);
        return books;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }


    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int id){
        repository.deleteById(id);
    }



}
