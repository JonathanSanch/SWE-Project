package com.company.geekTest.repository;

import com.company.geekTest.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    //List<Comment> findCommentsByBookbook_id(int book_id);
}
