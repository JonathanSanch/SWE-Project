package com.company.geekTest.repository;

import com.company.geekTest.model.Author;
import com.company.geekTest.model.Book;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findByIsbn(String isbn);

    List<Book> findByAuthorId(Integer author_id);

}