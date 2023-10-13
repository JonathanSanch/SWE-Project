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
    private int copies_sold;
    private int book_rating;
    private double book_price;
    private String isbn;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author_id;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher_id;

    public Book() {
    }

    public Book(Integer book_id, String book_name, String book_description, String book_year, int copies_sold, int book_rating, double book_price, String isbn, String genre, Author author_id, Publisher publisher_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_description = book_description;
        this.book_year = book_year;
        this.copies_sold = copies_sold;
        this.book_rating = book_rating;
        this.book_price = book_price;
        this.isbn = isbn;
        this.genre = genre;
        this.author_id = author_id;
        this.publisher_id = publisher_id;
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

    public int getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(int copies_sold) {
        this.copies_sold = copies_sold;
    }

    public int getBook_rating() {
        return book_rating;
    }

    public void setBook_rating(int book_rating) {
        this.book_rating = book_rating;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
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

    public Author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Author author_id) {
        this.author_id = author_id;
    }

    public Publisher getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Publisher publisher_id) {
        this.publisher_id = publisher_id;
    }
}
