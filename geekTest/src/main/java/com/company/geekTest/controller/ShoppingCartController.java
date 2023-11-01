package com.company.geekTest.controller;

import com.company.geekTest.model.Author;
import com.company.geekTest.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository repository;
}
