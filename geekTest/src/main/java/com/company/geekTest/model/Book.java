package com.company.geekTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String book_name;
    private String book_description;
    private String book_year;
    private String copies_sold;
    private String book_rating;
    private String book_price;
    private String isbn;
    private String genre;

    public Book() {
    }

    public Book(Integer book_id, String book_name, String book_description, String book_year, String copies_sold, String book_rating, String book_price, String isbn, String genre) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_description = book_description;
        this.book_year = book_year;
        this.copies_sold = copies_sold;
        this.book_rating = book_rating;
        this.book_price = book_price;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_year() {
        return book_year;
    }

    public void setBook_year(String book_year) {
        this.book_year = book_year;
    }

    public String getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(String copies_sold) {
        this.copies_sold = copies_sold;
    }

    public String getBook_rating() {
        return book_rating;
    }

    public void setBook_rating(String book_rating) {
        this.book_rating = book_rating;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
