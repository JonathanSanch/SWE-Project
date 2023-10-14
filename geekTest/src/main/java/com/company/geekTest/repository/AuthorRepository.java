package com.company.geekTest.repository;


import com.company.geekTest.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
