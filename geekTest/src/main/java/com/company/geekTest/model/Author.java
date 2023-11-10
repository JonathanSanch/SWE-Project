package com.company.geekTest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "author")
public class Author {


    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;

    private String first_name;
    private String last_name;
    private String biography;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;



    public Author() {
    }

    /**
     * Creates a new Author object with a Publisher
     * @param author_id  Primary identifier for each Author, auto-incremented by database
     * @param first_name
     * @param last_name
     * @param biography  Brief summary
     * @param publisher  Links to Publisher that Author is linked to
     */
    public Author(Integer author_id, String first_name, String last_name, String biography, Publisher publisher) {
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.biography = biography;
        this.publisher = publisher;
    }

    public Integer getId() {
        return author_id;
    }

    public void setId(Integer author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


}
