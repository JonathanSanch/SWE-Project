package com.company.geekTest.repository;

import com.company.geekTest.model.Book;
import com.company.geekTest.model.Customer;
import com.company.geekTest.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    // Find a shopping cart item by both customer and book
    ShoppingCart findByCustomerAndBook(Customer customer, Book book);

    // Find all shopping cart items for a specific customer
    List<ShoppingCart> findByCustomer(Customer customer);
}
