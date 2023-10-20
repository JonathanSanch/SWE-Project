package com.company.geekTest.repository;

import com.company.geekTest.model.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{

    @Query("SELECT AVG(rating.userRating) FROM Rating rating WHERE rating.book.book_id = :book_id")
    Double getAverageRatingForBook(@Param("book_id") int book_id);


}
