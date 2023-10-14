package com.company.geekTest.controller;

import com.company.geekTest.model.Book;
/*import com.company.geekTest.model.Customer;*/
import com.company.geekTest.repository.AuthorRepository;
import com.company.geekTest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    /*@Autowired
    private AuthorRepository authorRepository;*/

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Retrieve a book's details by the ISBN
   /* @GetMapping("/isbn/{isbn}")
    public List<Book> getBookByIsbn(@PathVariable String isbn) {
        List<Book> book = repository.findByIsbn(isbn);
        return book;
    }*/
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

    /*public ResponseEntity<Book> createBook(@RequestBody Book bookRequest) {
        // Fetch the author based on provided author_id
        Author author = authorRepository.findById(bookRequest.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Assign the author to the book
        bookRequest.setAuthor(author);

        // Save the book
        Book savedBook = bookRepository.save(bookRequest);

        // Return the saved book (this will also include the author's first and last name due to the relationship)
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);

    }*/


}
