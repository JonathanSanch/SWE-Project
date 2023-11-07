package com.company.geekTest.repository;


import com.company.geekTest.model.Author;
import com.company.geekTest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
