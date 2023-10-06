package com.company.geekTest.repository;

import com.company.geekTest.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
