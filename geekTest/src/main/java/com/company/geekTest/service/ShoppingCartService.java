package com.company.geekTest.service;


import com.company.geekTest.Exceptions.BookNotFoundException;
import com.company.geekTest.Exceptions.CustomerNotFoundException;
import com.company.geekTest.model.Book;
import com.company.geekTest.model.Customer;
import com.company.geekTest.model.ShoppingCart;
import com.company.geekTest.repository.BookRepository;
import com.company.geekTest.repository.CustomerRepository;
import com.company.geekTest.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShoppingCartService {

//    RETRIEVE SUBTOTAL PRICE OF ALL ITEMS IN A USER CART
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public double calculateSubtotal(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        List<ShoppingCart> cartItems = shoppingCartRepository.findByCustomer(customer);
        double subtotal = 0.0;

        for (ShoppingCart cartItem : cartItems) {
            subtotal += cartItem.getBook_id().getBook_price() * cartItem.getQuantity();
        }

        return subtotal;
    }

//    Retrieving Books in User Cart
    public List<Book> getBooksInUserCart(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        List<ShoppingCart> cartItems = shoppingCartRepository.findByCustomer(customer);
        List<Book> booksInCart = cartItems.stream()
                .map(ShoppingCart::getBook_id)
                .collect(Collectors.toList());
        return booksInCart;
    }

    public void addBookToCart(Integer bookId, Integer userId) {
        // Retrieve the book and customer entities
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        // Check if the book is already in the shopping cart
        Optional<ShoppingCart> existingCartItem = Optional.ofNullable(shoppingCartRepository.findByCustomerAndBook(customer, book));

        if (existingCartItem.isPresent()) {
            // If the item already exists, update the quantity
            ShoppingCart cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            // If the item doesn't exist, create a new cart item
            ShoppingCart newCartItem = new ShoppingCart();
            newCartItem.setBook_id(book);
            newCartItem.setCustomer_id(customer);
            newCartItem.setQuantity(1); // You can adjust the quantity as needed
            shoppingCartRepository.save(newCartItem);
        }
    }

}


