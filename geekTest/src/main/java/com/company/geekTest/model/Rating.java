package com.company.geekTest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "rating")
public class Rating {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rating_id;
    @Column(name = "user_rating")
    private int userRating;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "date_stamp")
    private String dateStamp;


    public Rating() {

    }

    public Rating(Integer rating_id, int userRating, Customer customer, Book book, String dateStamp) {
        this.rating_id = rating_id;
        this.userRating = userRating;
        this.customer = customer;
        this.book = book;
        this.dateStamp = dateStamp;
    }

    public Integer getRating_id() {
        return rating_id;
    }
    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }
    public int getUserRating() {
        return userRating;
    }
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer_id) {
        this.customer = customer_id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public String getDateStamp() {
        return dateStamp;
    }
    public void setDateStamp(String dateStamp) {
        this.dateStamp = this.dateStamp;
    }
    @PrePersist
    protected void onCreate() {
        dateStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
