package com.company.geekTest.controller;

import com.company.geekTest.model.Comment;
import com.company.geekTest.model.Book;
import com.company.geekTest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CommentController {

    @Autowired
    CommentRepository repository;

   @GetMapping("/comments")
   @ResponseStatus(HttpStatus.FOUND)
   public List<Comment> getAllComments() {
       return repository.findAll();
   }
   @PostMapping( "/comments")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void addComment(@RequestBody Comment comment) {
       repository.save(comment);
   }

    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int id){
        repository.deleteById(id);
    }

    /*@GetMapping("/comments/book/{book_id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Comment> getCommentByBookId(@PathVariable int book_id) {
       return repository.findCommentsByBookbook_id(book_id);
    }
*/

}
