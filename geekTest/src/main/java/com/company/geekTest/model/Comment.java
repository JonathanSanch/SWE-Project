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
    private Customer customer_id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;
    @Column(name = "date_stamp")
    private String dateStamp;
    public Comment() {

    }

    public Comment(Integer comment_id, String userComment, Customer customer_id, Book book_id, String dateStamp) {
        this.comment_id = comment_id;
        this.userComment = userComment;
        this.customer_id = customer_id;
        this.book_id = book_id;
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
        return customer_id;
    }
    public void setCustomer(Customer customer_id) {
        this.customer_id = customer_id;
    }
    public Book getBook() {
        return book_id;
    }
    public void setBook(Book book_id) {
        this.book_id = book_id;
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
