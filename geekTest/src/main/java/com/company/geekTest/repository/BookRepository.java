package com.company.geekTest.repository;

import com.company.geekTest.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
   /* List<Book> findByAuthorId(Integer author_id);
    List<Book> findByIsbn(String isbn);*/
}
