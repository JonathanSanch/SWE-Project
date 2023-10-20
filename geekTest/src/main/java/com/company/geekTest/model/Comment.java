package com.company.geekTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;
    @Column(name = "user_comment")
    private String userComment;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "date_stamp")
    private String dateStamp;
    public Comment() {

    }

    public Comment(Integer comment_id, String userComment, Customer customer, Book book, String dateStamp) {
        this.comment_id = comment_id;
        this.userComment = userComment;
        this.customer = customer;
        this.book = book;
        this.dateStamp = dateStamp;

    }
    public int getComment_id() {
        return comment_id;
    }
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }
    public String getUserComment() {
        return userComment;
    }
    public void setUserComment(String userComment) {
        this.userComment = userComment;
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
        this.dateStamp = dateStamp;
    }
    @PrePersist
    protected void onCreate() {
        dateStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


}
