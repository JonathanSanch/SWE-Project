package com.company.geekTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;
    private int quantity;
    private Date date_added;

    public ShoppingCart() {}

    public ShoppingCart(Integer cart_id, Customer customer_id, Book book_id, int quantity, Date date_added) {
        this.cart_id = cart_id;
        this.customer_id = customer_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.date_added = date_added;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }
}
