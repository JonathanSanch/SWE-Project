package com.company.geekTest.repository;
import com.company.geekTest.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    @Query("SELECT comment.userComment FROM Comment comment WHERE comment.book.book_id = :book_id")
    List<String> getCommentsForBook(@Param("book_id") int book_id);


}
