package com.company.geekTest.repository;

import com.company.geekTest.model.*;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{

    //List<Rating> findByBook_book_id(int book_id);
}
