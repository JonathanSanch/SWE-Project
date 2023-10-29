package com.company.geekTest.repository;

import com.company.geekTest.model.Author;
import com.company.geekTest.model.Book;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findByIsbn(String isbn);

    List<Book> findByGenre(String genre);


    //returns a list of 10 books sorted by most copies sold
    @Query(value = "SELECT * FROM book a ORDER BY a.copies_sold DESC LIMIT 10", nativeQuery = true)
    List<Book> getTopSellers();


    //returns a list of all books with a rating greater than or equal to the rating passed.
    @Query(value = "SELECT * FROM book a WHERE a.book_rating >= :rating", nativeQuery = true)
    List<Book> getBetterThanRating(@Param("rating") float rating);

    //returns a list of all books under a certain publisher using either the publisher ID or the publisher name
    //
    @Query(value = "select * from book a, publisher b where a.publisher_id = (select b.publisher_id where b.publisher_name = :publisher)", nativeQuery = true)
    List<Book> findByPublisher(@Param("publisher") String publisher);

    @Query(value = "select * from book a where a.publisher_id = :publisher", nativeQuery = true)
    List<Book> findByPublisher(@Param("publisher") int publisher);

    @Modifying
    @Query(value = "update book set book_price = TRUNCATE((book_price * :discount), 2) where publisher_id = :publisher", nativeQuery = true)
    void discountByPublisher(@Param("discount") float discount, @Param("publisher") int publisher);


   // List<Book> findByAuthorId(Author author_id);     // **WIP****


    /*@Query(value = "SELECT * FROM Author a FETCH JOIN a.books b WHERE a.author_id = b.author")*/   ///WIP 2nd Option
    List<Book> findByAuthorId(Integer author_id);

}