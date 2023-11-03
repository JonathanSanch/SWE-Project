package com.company.geekTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntitializer", "handler"})
@Table(name = "customer")
public class Customer
{
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    private String username;
    private String user_password;
    private String user_first_name;
    private String user_last_name;
    private String email;
    private String address;
    private String credit_card;

    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;

    public Customer(){}


    public Customer(int customer_id, String username, String user_password, String user_first_name,
                    String user_last_name, String email, String address, String credit_card) {
        this.customer_id = customer_id;
        this.username = username;
        this.user_password = user_password;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.email = email;
        this.address = address;
        this.credit_card = credit_card;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }
}
