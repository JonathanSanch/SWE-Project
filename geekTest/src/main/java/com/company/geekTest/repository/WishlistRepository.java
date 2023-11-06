package com.company.geekTest.repository;



import com.company.geekTest.model.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {


}