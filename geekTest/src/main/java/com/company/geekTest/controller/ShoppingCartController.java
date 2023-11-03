package com.company.geekTest.controller;

import com.company.geekTest.model.Author;
import com.company.geekTest.model.Book;
import com.company.geekTest.model.Customer;
import com.company.geekTest.repository.ShoppingCartRepository;
import com.company.geekTest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

//    Get subtotal of shoppingCart
    @GetMapping("cart/subtotal/{userId}")
    public ResponseEntity<Double> calculateSubtotal(@PathVariable Integer userId) {
        double subtotal = shoppingCartService.calculateSubtotal(userId);
        return ResponseEntity.ok(subtotal);
    }


//    RETRIEVE LIST OF BOOKS IN USER'S SHOPPING CART
    @GetMapping("/cart/books/{userId}")
    public ResponseEntity<List<Book>> getBooksInUserCart(@PathVariable Integer userId) {
        List<Book> booksInCart = shoppingCartService.getBooksInUserCart(userId);
        return ResponseEntity.ok(booksInCart);
    }


//    ADD BOOK TO SHOPPING CART
@PostMapping("/cart/{userId}/add/{bookId}")
public ResponseEntity<Void> addBookToCart(@PathVariable Integer userId, @PathVariable Integer bookId) {
    shoppingCartService.addBookToCart(bookId, userId);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}


//    DELETE A BOOK FROM SHOPPING CART


}
