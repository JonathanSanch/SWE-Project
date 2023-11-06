package com.company.geekTest.repository;


import com.company.geekTest.model.Wishlist;
import com.company.geekTest.model.Wishlist;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
